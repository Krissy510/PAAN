import java.sql.SQLException;
import java.util.ArrayList;
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
        this.mood = (TaskEvent) TaskFactory.createTask("event", "None");
        this.todoList = new TodoList();
        this.eventList = new EventList();
        this.timeline = new EventList();
        this.focusDate = new Date();
        try {
            this.pdao = new PaanDAO();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        initialize();
    }

    private void initialize(){
        LinkedList<String> arr = new LinkedList<>();
        arr.add("daily");
        arr.add("event");
        arr.add("mood");
        arr.add("todo");
        arr.add("water");
        arr.add("userSettings");
        arr.removeIf(tableName -> pdao.checkExist(tableName));
        // If there is Table missing arr.size() != 0
        if(arr.size() != 0){
            for (String missing:
                 arr) {
                pdao.createTable(missing); // Create the missing table
//                if(missing.equals("userSettings"))
            }
        }

//        loadTimeline();
//        loadUserSettings();
    }

    public void setSettings(String type, int val){
        if(type.equals("theme")) theme = val;
        else timeFormat = val;
        pdao.updateSettings(type,val);
    }

    public void loadTimeline(){
        timeline = pdao.loadTimeline();
    }

    public void loadUserSettings(){
        theme = pdao.loadSettings("theme");
        timeFormat = pdao.loadSettings("timeFormat");
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

    public LinkedList<TaskEvent> getEventList(){
        return eventList.getTaskEventLinkedList();
    }

    public LinkedList<TaskEvent> getTimelineList() {
        return timeline.getTaskEventLinkedList();
    }
}
