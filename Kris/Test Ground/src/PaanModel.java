import java.sql.SQLException;
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
    PaanDAO pdao;

    // data attr
    private TaskEvent mood;
    private TodoList todoList;
    private EventList eventList;
    private EventList timeline;


    public PaanModel() {
        this.todoList = new TodoList();
        this.eventList = new EventList();
        this.timeline = new EventList();
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
        loadTodoList();
        loadMood();
        if(mood == null){
            this.mood = (TaskEvent) TaskFactory.createTask("event", "None");
        }
    }

    // Timeline
    public void loadTimeline(){
        timeline = pdao.loadTimeline();
    }

    public LinkedList<TaskEvent> getTimelineList() {
        return timeline.getTaskEventLinkedList();
    }

    // Setting
    public void loadUserSettings(){
        theme = pdao.loadSettings("theme");
        timeFormat = pdao.loadSettings("timeFormat");
    }

    // Use for update val of setting both local and at the db
    // Ex. setSettings("theme", 1);
    public void updateSettings(String type, int val){
        if(type.equals("theme")) theme = val;
        else timeFormat = val;
        pdao.updateSettings(type,val);
    }

    // 0 : light
    // 1 : dark
    public int getTheme(){
        return theme;
    }

    // 0 : 24 hrs
    // 1 : 12 hrs format
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

    public void insertMood(String felt){
        mood.setDetail(felt);
        pdao.insert("mood",felt,focusDate);
    }

    public String getMood(){
        return mood != null? mood.getDetail():null ;
    }

    public void updateMood(){

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




}
