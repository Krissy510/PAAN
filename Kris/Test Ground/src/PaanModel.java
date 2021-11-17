import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Observable;

public class PaanModel extends Observable {

    // user setting attr
    private int timeFormat;
    private int theme;
    private int drink;

    // track date attr
    private Date focusDate;

    // DAO
    private PaanDAO pdao;

    // data attr
    private TaskEvent mood;
    private TodoList todoList;
    private TodoList dailyList;
    private EventList eventList;
    private LinkedList<TaskEvent> timeline;
    private TimeTable timeTable;

    // Default Constructor
    public PaanModel() {
        this.focusDate = new Date(); // current Date
        try {
            this.pdao = new PaanDAO();
            initialize();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

    }

    // Initialize method for constructor only
    private void initialize(){
        LinkedList<String> arr = new LinkedList<>();
        arr.add("dailyTask");
        arr.add("event");
        arr.add("mood");
        arr.add("todo");
        arr.add("daily");
        arr.add("userSettings");
        arr.add("time");
        arr.removeIf(tableName -> pdao.checkExist(tableName));
        // If there is Table missing arr.size() != 0
        if(arr.size() != 0){
            for (String missing:
                 arr) {
                pdao.createTable(missing); // Create the missing table
            }
        }
        // Menu
        if(!pdao.checkDataExist("userSettings")) pdao.insert(0,0);
        loadTimeline();
        loadUserSettings();
        // Memo
        memoLoad();
        // Daily
        if(!pdao.checkDataExist("dailyTable")) pdao.insert(0,focusDate);
        dailyLoad();
        // Table
        loadTimeTable();
    }

    // memo load page
    public void memoLoad(){
        loadTodoList();
        loadMood();
        loadEvent();
    }

    // daily load
    public void dailyLoad(){
        loadDailyTask();
        loadDrink();
    }


    /// Timeline
    public void loadTimeline(){
        timeline = pdao.loadTimeline();
        if(timeline == null) this.timeline = new LinkedList<>();
    }

    public LinkedList<TaskEvent> getTimelineList() {
        return timeline;
    }

    /// Setting
    public void loadUserSettings(){
        theme = pdao.loadSettings("theme");
        timeFormat = pdao.loadSettings("timeFormat");
    }

    // Use for update val of setting both local and at the db
    // THEME
    // 0 : light
    // 1 : dark
    // TIME FORMAT
    // 0 : 24 hrs
    // 1 : 12 hrs format
    // Ex. setSettings("theme", 1);
    public void updateSettings(String type, int val){
        if(type.equals("theme")) theme = val;
        else timeFormat = val;
        pdao.updateSettings(type,val);
    }

    public int getTheme(){
        return theme;
    }

    public int getTimeFormat(){
        return timeFormat;
    }


    /// Mood
    // Format we mostly use yyyy-mm-dd for date
    // and hh:mm for time

    // load mood at focus date
    public void loadMood(){
        mood = pdao.loadMood(focusDate);
    }

    public String getMood(){
        return mood != null? mood.getDetail():"None" ;
    }

    public void updateMood(String felt){
        if(mood == null){
            pdao.insert("mood",felt,focusDate);
            mood = (TaskEvent) TaskFactory.createTask(felt,focusDate);
        }
        else{
            pdao.update("mood",felt,focusDate);
            mood.setDetail(felt);
        }
    }


    /// Todolist
    public void loadTodoList(){
        todoList = pdao.loadTodoList("todoTable");
        if(todoList == null) dailyList = new TodoList();
    }

    public boolean addTodoTask( String detail){
        if(todoList.isDuplicate(detail)) return false;
        pdao.insert("todoTable",detail);
        todoList.addTask(detail);
        return true;
    }

    public void removeTodoTask(int index){
        pdao.remove("todoTable",index+1);
        todoList.deleteTask(index);
    }

    public void todoListCheck(String detail){
        pdao.updateTodo("todoTable",1,detail);
        loadTodoList();
    }

    public void todoListUncheck(String detail){
        pdao.updateTodo("todoTable",0,detail);
        loadTodoList();
    }

    public  LinkedList<TaskList> getTodoList(){
        return todoList.getTodoList();
    }

    /// Daily
    public void loadDailyTask(){
        dailyList = pdao.loadTodoList("dailyTaskTable");
        if(dailyList == null) dailyList = new TodoList();
    }

    public boolean addDailyTask(String detail){
        if(dailyList.isDuplicate(detail)) return false;
        pdao.insert("dailyTaskTable",detail);
        dailyList.addTask(detail);
        return true;
    }

    public void removeDailyTask(int index){
        pdao.remove("dailyTaskTable",index+1);
        dailyList.deleteTask(index);
    }

    public void dailyListCheck(String detail){
        pdao.updateTodo("dailyTaskTable",1,detail);
        loadDailyTask();
    }

    public void dailyListUncheck(String detail){
        pdao.updateTodo("dailyTaskTable",0,detail);
        loadDailyTask();
    }

    public boolean checkReset(){
        Date current = new Date();
        Date comp = pdao.getResetDate();
        if (!comp.after(current)){
            pdao.clearDailyTask();
            pdao.updateDaily(current);
            this.drink = 0;
            pdao.updateDaily(drink);
            loadDailyTask();
            return true;
        }
        else return false;
    }

    public void addDrink(){
        this.drink++;
        pdao.updateDaily(drink);
    }

    public void removeDrink(){
        this.drink--;
        pdao.updateDaily(drink);
    }

    public int getDrink(){return drink;}

    public void loadDrink(){
        this.drink = pdao.loadDrink();
    }

    public LinkedList<TaskList> getDailyTask() {return dailyList.getTodoList();}

    public int getDailyTotal(){return dailyList.getTotal();}
    public int getDailyCheck(){return dailyList.getChecked();}
    public int getDailyUncheck(){return dailyList.getUnchecked();}

    // EventList
    public boolean addEventTask(String detail, String time){
        try {
            String date = (focusDate.getYear()+1900)+"-"+(focusDate.getMonth()+1)+"-"+(focusDate.getDate())+" "+time;
            System.out.println(date);
            Date temp = new SimpleDateFormat("yyyy-MM-dd").parse((focusDate.getYear()+1900)+"-"+(focusDate.getMonth()+1)+"-"+(focusDate.getDate()));
            System.out.println(temp);
            if (eventList.isDuplicate(detail,new SimpleDateFormat("HH:mm").format(temp))){
                System.out.println("Task already existed");
                return false;
            }
            pdao.insert("event",detail,new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date));
            eventList.addTask(detail,date);
            return true;
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void removeEventTask(int index){
        TaskEvent temp = eventList.getOBJTask(index);
        pdao.remove(temp.getDetail(),temp.getDate());
        eventList.removeTask(index);
    }

    public LinkedList<TaskEvent> getEventList(){
        return eventList.getTaskEventLinkedList();
    }

    public void loadEvent(){
        eventList = pdao.loadEvent(focusDate);
        if(eventList == null) this.eventList = new EventList();
    }


    /// Focus Date
    public void setDate(String date){
        try {
            Date cDate = new Date();
            if(date.equals(new SimpleDateFormat("yyyy-MM-dd").format(cDate))) resetFocusDate();
            else this.focusDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    public Date getFocusDate() {
        return focusDate;
    }

    // Reset date to current
    public void resetFocusDate(){
        focusDate = new Date(); // Current
    }


    /// Table
    public void loadTimeTable(){
        this.timeTable = pdao.loadTimeTable();
        if(timeTable == null) this.timeTable = new TimeTable();
    }
    public LinkedList<Table> getTimeTabelList(){
        return timeTable.getTableList();
    }

    public boolean addTable(int day, String startTime, String endTime, String task){
        if(timeTable.isAvailable(day,startTime,endTime,task)){
            timeTable.add(day,startTime,endTime,task);
            return true;
        }else return false;
    }

    public void removeTable(int index){
        timeTable.removeTable(index);
        Table temp = timeTable.getTable(index);
        pdao.remove(temp);
    }

    public boolean checkAddAvailable(int day, String startTime, String endTime, String task){
        return timeTable.isAvailable(day,startTime,endTime,task);
    }

    public LinkedList<Table> getTableList(){
        return timeTable.getTableList();
    }
}
