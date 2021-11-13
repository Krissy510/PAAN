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


    public PaanDAO() throws SQLException {
        this.connect();
        if(cnn != null) this.st = cnn.createStatement();
    }

    public void updateSettings(String type, int val){
        String sql = "UPDATE userSettings SET "+type+" = "+val+";";
        try{
            st.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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

}
