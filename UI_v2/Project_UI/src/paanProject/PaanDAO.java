package project_ui;

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

    // To establish a connect to sqlite Database
    private void connect() {
        cnn = null;
        try {
            cnn = DriverManager.getConnection("jdbc:sqlite:taskdb.db");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Default Constructor
    public PaanDAO() throws SQLException {
        this.connect();
        if(cnn != null) this.st = cnn.createStatement();
    }


    /// Utility
    // Check Table Exist method
    public boolean checkExist(String tableName){
        String query = "SELECT name FROM sqlite_master WHERE name='"+tableName;
        if(tableName.equals("userSettings")) query += "'";
        else query += "Table'";
        try{
            rs = st.executeQuery(query);
            return !rs.isClosed();
        } catch (SQLException e) {
            System.out.println(tableName + " is missing.");
        }
        return false;
    }

    // Check if that table has a data
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

    // Create Table in case table is missing
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
            case "time":
                command += "Table (day INTEGER NOT NULL, startTime TEXT,endTime TEXT,task TEXT);";
                break;
        }
        try{
            st.execute(command);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Clear all status in DailyTask
    public void clearDailyTask(){
        String query = "UPDATE dailyTaskTable SET status = 0";
        try {
            st.execute(query);
        } catch (SQLException e) {
            System.out.println("Fail at clearDailyTask()");
        }
    }


    /// Insert Method
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

    // For Event and Mood
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


    /// Update Method
    // Update for UserSetting
    public void updateSettings(String type, int val){
        String query = "UPDATE userSettings SET "+type+" = "+val+";";
        try{
            st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Update for Event and Mood
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

    // Update drink
    public void updateDaily(int val){
        String query = "UPDATE dailyTable SET drink = "+val;
        try {
            st.execute(query);
        } catch (SQLException e) {
            System.out.println("Fail at updateDaily");
        }
    }

    // Update date after clear
    public void updateDaily(Date newDate){
        String tmrw = (newDate.getYear()+1900)+"-"+(newDate.getMonth()+1)+"-"+(newDate.getDate()+1);
        String query = "UPDATE dailyTable SET dateTime = '"+tmrw+"'";
        try {
            st.execute(query);
        } catch (SQLException e) {
            System.out.println("Fail at updateDaily");
        }
    }

    // Update detail of the record
    public void updateTodo(String table,int status, String detail){
        String query = "UPDATE "+table+" SET status = "+status+" WHERE detail = '"+detail+"';";
        try{
            st.execute(query);
        } catch (SQLException e) {
            System.out.println("Remove "+table+"failed");
        }
    }


    /// Load Method
    // Load setting for each type
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

    // Load linked list for timeline
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

    // Load TodoList for todolist and daily
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

    // Load value for current Drink
    public int loadDrink(){
        String query = "SELECT drink FROM dailyTable";
        try{
            rs = st.executeQuery(query);
            if(!rs.isClosed()) return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println("Failed at loadDrink");
        }
        return 0;
    }

    // Load TaskEvent for mood using date
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

    // Load Eventlist range frome date to date+1
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

    // Load TimeTable
    public TimeTable loadTimeTable(){
        String query =  "SELECT * FROM timeTable ORDER BY day ASC";
        try{
            rs = st.executeQuery(query);
            TimeTable temp = new TimeTable();
            while(rs.next()) {
                temp.add(rs.getInt("day"),
                        rs.getString("startTime"),
                        rs.getString("endTime"),
                        rs.getString("task"));
            }
            return temp;
        } catch (SQLException e) {
            System.out.println("Failed at load timetable");
            System.out.println(e.getMessage());
        }
        return null;
    }


    /// Remove Method
    // Event
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
    public void remove(String table,int rowId){
        String query = "DELETE FROM "+table+" WHERE ROWID = "+rowId;
        try{
            st.execute(query);
        } catch (SQLException e) {
            System.out.println("Remove "+table+" failed");
        }
    }
    // Table
    public void remove(Table table){
        String query = "DELETE FROM timeTable WHERE day == "+table.getDay()+" AND startTime == '"+ table.getStrStartTime()+"' AND endTime == '"+ table.getStrEndTime()+"' AND task == '"+table.getTask()+"'";
        try{
            st.execute(query);
        } catch (SQLException e) {
            System.out.println("Remove timeTable failed");
        }
    }


    /// Get Method
    // Get the dest reset date
    public Date getResetDate(){
        String query = "SELECT dateTime FROM dailyTable";
        try {
            rs = st.executeQuery(query);
            return new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString(1));

        } catch (SQLException | ParseException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
