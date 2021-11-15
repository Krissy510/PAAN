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


    public PaanModel() {
        this.focusDate = new Date();
        try {
            this.pdao = new PaanDAO();
            initialize();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

    }

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
        loadTodoList();
        memoLoad();
        // Daily
        if(!pdao.checkDataExist("dailyTable")) pdao.insert(0,focusDate);
        loadDailyTask();
        loadDrink();
    }

    public void memoLoad(){
        loadMood();
        loadEvent();
    }

    // Timeline
    public void loadTimeline(){
        timeline = pdao.loadTimeline();
        if(timeline == null) this.timeline = new LinkedList<>();
    }

    public LinkedList<TaskEvent> getTimelineList() {
        return timeline;
    }

    // Setting
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


    // Mood
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

    public boolean addEventTask(String detail, String date){
        try {
            Date temp = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date);
            if (eventList.isDuplicate(detail,new SimpleDateFormat("HH:mm").format(temp))){
                System.out.println("Task already existed");
                return false;
            }
            pdao.insert("event",detail,temp);
            eventList.addTask(detail,date);
            return true;
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


    // Todolist
    public void loadTodoList(){
        todoList = pdao.loadTodoList("todoTable");
        if(todoList == null) dailyList = new TodoList();
    }

    public  LinkedList<TaskList> getTodoList(){
        return todoList.getTodoList();
    }

    // Daily
    public void loadDailyTask(){
        dailyList = pdao.loadTodoList("dailyTaskTable");
        if(dailyList == null) dailyList = new TodoList();
    }

    public LinkedList<TaskList> getDailyTask() {return dailyList.getTodoList();}

    public int getDailyTotal(){return dailyList.getTotal();}
    public int getDailyCheck(){return dailyList.getChecked();}
    public int getDailyUncheck(){return dailyList.getUnchecked();}

    // EventList
    public LinkedList<TaskEvent> getEventList(){
        return eventList.getTaskEventLinkedList();
    }

    // reset date
    public void resetFocusDate(){
        focusDate = new Date(); // Current
    }

    public void loadEvent(){
        eventList = pdao.loadEvent(focusDate);
        if(eventList == null) this.eventList = new EventList();
    }

    public void setDate(String date){
        try {
            Date cDate = new Date();
            if(date.equals(new SimpleDateFormat("yyyy-MM-dd").format(cDate))) resetFocusDate();
            this.focusDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    public Date getFocusDate() {
        return focusDate;
    }

    public void removeEventTask(int index){
        TaskEvent temp = eventList.getOBJTask(index);
        pdao.remove(temp.getDetail(),temp.getDate());
        eventList.removeTask(index);
    }

    public boolean addTodoTask( String detail){
        if(todoList.isDuplicate(detail)) return false;
        pdao.insert("todoTable",detail);
        todoList.addTask(detail);
        return true;
    }


    public boolean addDailyTask(String detail){
        if(dailyList.isDuplicate(detail)) return false;
        pdao.insert("dailyTaskTable",detail);
        dailyList.addTask(detail);
        return true;
    }

    public void removeTodoTask(String detail){
        pdao.remove("todoTable",detail);
        todoList.deleteTask(detail);
    }

    public void removeDailyTask(String detail){
        pdao.remove("dailyTaskTable",detail);
        dailyList.deleteTask(detail);
    }

    public void todoListCheck(String detail){
        pdao.updateTodo("todoTable",1,detail);
        loadTodoList();
    }

    public void todoListUncheck(String detail){
        pdao.updateTodo("todoTable",0,detail);
        loadTodoList();
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

}
