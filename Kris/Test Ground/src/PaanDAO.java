import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public void insert(String table,Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

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

    public EventList loadTimeline(){
        Date current = new Date(); // Current  date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String query = "SELECT * FROM eventTable " + "WHERE  dateTime >= " + "\"" +sdf.format(current) + "\"" + " ORDER BY dateTime ASC";
        EventList temp = new EventList();
        try {
            rs = st.executeQuery(query);
            while(rs.next()){
                temp.addTask(rs.getString("detail"),
                        rs.getString("dateTime"));
            }
            return temp;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public TodoList loadTodoList(){
        String query = "SELECT * FROM todoTable ORDER BY status ASC";
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdf.format(date);
        String query = "SELECT * FROM moodTable WHERE dateTime == '" + dateStr + "'";
        try{
            rs = st.executeQuery(query);
            if(!rs.isClosed()) return  (TaskEvent) TaskFactory.createTask(rs.getString("detail"),date);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}
