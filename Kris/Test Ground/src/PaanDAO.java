import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class PaanDAO {
    // sql attr
    private Connection cnn;
    private Statement st;
    private ResultSet rs;

    private void connect() {
        cnn = null;
        try {
            cnn = DriverManager.getConnection("jdbc:sqlite:taskdb.db");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Constructor
    public PaanDAO() throws SQLException {
        this.connect();
        if(cnn != null) this.st = cnn.createStatement();
    }

    // Check Method
    public boolean checkExist(String tableName){
        String query = "SELECT name FROM sqlite_master WHERE name='"+tableName;
        if(tableName.equals("userSettings")) query += "'";
        else query += "Table'";
        try{
            rs = st.executeQuery(query);
            return rs.getString(1) != null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean checkDataExist(String tableName){
        String query = "SELECT * FROM "+tableName;
        try{
            rs = st.executeQuery(query);
            return !rs.isClosed();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // Create Table
    public void createTable(String tableName){
        String command = "CREATE TABLE IF NOT EXISTS "+tableName;
        switch (tableName) {
            case "dailyTask":
            case "todo":
                command += "Table (status INTEGER NOT NULL,detail TEXT);";
                break;
            case "event":
                command += "Table (detail TEXT, dateTime TEXT);";
                break;
            case "mood":
                command += "Table (detail TEXT, dateTime TEXT);";
                break;
            case "theme":
                command += "Table (theme INTEGER, timeFormat INTEGER);";
                break;
            case "daily":
                command += "Table (drink INTEGER NOT NULL, dateTime TEXT);";
                break;
            case "userSettings":
                command += " (theme INTEGER NOT NULL, timeFormat INTEGER NOT NULL);";
                break;
        }
        try{
            st.execute(command);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    // Insert Method
    // For userSettings
    public void insert(int theme, int timeFormat){
        String query = "INSERT INTO userSettings(theme,timeFormat) VALUES("+theme+","+timeFormat+")";
        try{
            st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // For TaskTable
    public void insert(int drink,Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = "'" + sdf.format(date) + "'";
        String query = "INSERT INTO dailyTable (drink,dateTime) VALUES("+drink+","+dateStr+")";
        try{
            st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // For event and mood
    public void insert(String table,String detail,Date date){
        SimpleDateFormat sdf;
        if(table.equals("mood"))sdf = new SimpleDateFormat("yyyy-MM-dd");
        else sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String query = "INSERT INTO " + table+"Table (detail,dateTime) VALUES( '"+detail+"','"+sdf.format(date)+"')" ;
        try{
            st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // For Daily and Todolist
    public void insert(String table, String detail){
        String query = "INSERT INTO " + table + " (status,detail) VALUES( 0,'"+detail+"')";
        try{
            st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    // Update Method
    public void updateSettings(String type, int val){
        String query = "UPDATE userSettings SET "+type+" = "+val+";";
        try{
            st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // for event and mood
    public void update(String table, String detail, Date date){
        String dateStr;
        if(table.equals("event")) dateStr = "'"+new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date)+"'";
        else dateStr = "'"+new SimpleDateFormat("yyyy-MM-dd").format(date)+"'";
        String query = "UPDATE "+table+"Table SET detail = '"+detail+"' WHERE dateTime = "+dateStr;
        try{
            st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }




    // Load Method
    public int loadSettings(String type){
        String query = "SELECT " + type + " FROM userSettings";
        try {
            int temp;
            rs = st.executeQuery(query);
            rs.next();
            temp = rs.getInt(1);
            return temp;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public LinkedList<TaskEvent> loadTimeline(){
        Date current = new Date(); // Current  date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String query = "SELECT * FROM eventTable " + "WHERE  dateTime >= " + "\"" +sdf.format(current) + "\"" + " ORDER BY dateTime ASC";
        LinkedList<TaskEvent> temp = new LinkedList<>();
        try {
            rs = st.executeQuery(query);
            while(rs.next()){
                temp.add((TaskEvent)TaskFactory.createTask("event",
                        rs.getString("detail"),
                        rs.getString("dateTime")));
            }
            return temp;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public TodoList loadTodoList(String tableName){
        String query = "SELECT * FROM "+tableName+" ORDER BY status ASC";
        TodoList temp = new TodoList();
        try {
            rs = st.executeQuery(query);
            while(rs.next()){
                temp.addTask(rs.getString(2), rs.getInt(1) == 1);
            }
            return temp;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public TaskEvent loadMood(Date date){
        String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
        String query = "SELECT * FROM moodTable WHERE dateTime == '" + dateStr + "'";
        try{
            rs = st.executeQuery(query);
            if(!rs.isClosed()) return  (TaskEvent) TaskFactory.createTask(rs.getString("detail"),date);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public EventList loadEvent(Date date){
        String dateCstr = "'"+new SimpleDateFormat("yyyy-MM-dd").format(date)+"'";
        String dateSstr = (date.getYear()+1900)+"-"+(date.getMonth()+1)+"-"+(date.getDate()+1);
        try {
            Date temp = new SimpleDateFormat("yyyy-MM-dd").parse(dateSstr);
            dateSstr = "'"+new SimpleDateFormat("yyyy-MM-dd").format(temp)+"'";
            EventList eventList = new EventList();
            rs = st.executeQuery("SELECT * FROM eventTable WHERE dateTime >= "+dateCstr+" AND dateTime < "+dateSstr+" ORDER BY datetime ASC");
            while(rs.next()){
                eventList.addTask(rs.getString(1),rs.getString(2));
            }
            eventList.sort();
            return eventList;
        } catch (ParseException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    // event
    public boolean isDuplicate(String detail, Date checkDate){
            String checkDateStr = "'"+new SimpleDateFormat("yyyy-MM-dd HH:mm").format(checkDate)+"'";
            String query = "SELECT * FROM eventTable WHERE detail == '"+detail+"' AND dateTime == "+checkDateStr;
            try{
                rs = st.executeQuery(query);
                return !rs.isClosed();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return true;
    }

    // TodoList and daily
    public boolean isDuplicate(String table,String detail){
        String query = "SELECT * FROM "+table+" WHERE detail == '"+detail+"'";
        try{
            rs = st.executeQuery(query);
            return !rs.isClosed();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }


    // event
    public void remove(String detail, Date delDate){
        String delDateStr = "'"+new SimpleDateFormat("yyyy-MM-dd HH:mm").format(delDate)+"'";
        String query = "DELETE FROM eventTable WHERE detail == '"+detail+"' AND dateTime == "+ delDateStr;
        try{
            st.execute(query);
        } catch (SQLException e) {
            System.out.println("Remove event failed");
        }
    }

    // Todolist
    public void remove(String table, String detail){
        String query = "DELETE FROM "+table+" WHERE detail == '"+detail+"'";
        try{
            st.execute(query);
        } catch (SQLException e) {
            System.out.println("Remove "+table+"failed");
        }
    }

}
