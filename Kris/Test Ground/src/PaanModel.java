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

    // track date attr
    private Date focusDate;

    // DAO
    private PaanDAO pdao;

    // data attr
    private TaskEvent mood;
    private TodoList todoList;
    private EventList eventList;
    private LinkedList<TaskEvent> timeline;


    public PaanModel() {
        this.todoList = new TodoList();
        this.eventList = new EventList();
        this.timeline = new LinkedList<>();
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
        arr.removeIf(tableName -> pdao.checkExist(tableName));
        // If there is Table missing arr.size() != 0
        if(arr.size() != 0){
            for (String missing:
                 arr) {
                pdao.createTable(missing); // Create the missing table
            }
        }
        if(!pdao.checkDataExist("userSettings")) pdao.insert(0,0);
        if(!pdao.checkDataExist("dailyTable")) pdao.insert(0,focusDate);
        loadTimeline();
        loadUserSettings();
        memoLoad();
    }

    public void memoLoad(){
        loadTodoList();
        loadMood();
        loadEvent();
    }

    // Timeline
    public void loadTimeline(){
        timeline = pdao.loadTimeline();
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
            if (pdao.isDuplicate(detail,temp)){
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
    public void loadTodoList(){ todoList = pdao.loadTodoList();}

    public  LinkedList<TaskList> getTodoList(){
        return todoList.getTodoList();
    }

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
    }

    public void setDate(String date){
        try {
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
        pdao.remove(temp.getDetail(),temp.getDateObj());
        eventList.removeTask(index);
    }
}
