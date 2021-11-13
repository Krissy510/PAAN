import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskEvent extends Task{
    // Due date of the task
    private Date date;
    private final SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm");


    // default constructor when there is none
    public TaskEvent(){
        super();
        this.date = new Date();
    }

    // OVERLOAD: constructor with only String
    public TaskEvent(String detail) {
        super(detail);
        this.date = new Date();
    }

    // OVERLOAD: constructor with String and obj Date
    public TaskEvent(String detail, Date date) {
        super(detail);
        this.date = date;
    }

    // OVERLOAD: constructor with String and String Date
    public TaskEvent(String detail, String date) {
        super(detail);
        try{
            this.date = ft.parse(date);
        } catch (ParseException e) {
            // If the format is wrong it will automatically set due date as current Date
            System.out.println("Incorrect format");
            this.date = new Date();
        }
    }

    // get time
    public String getTime(){
        SimpleDateFormat time = new SimpleDateFormat("HH:mm");
        return time.format(date);
    }

    // get date
    public String getDate(){
        SimpleDateFormat time = new SimpleDateFormat("dd/MM/yyyy");
        return time.format(date);
    }

    // set due date with OBJ
    public void setDate(Date duedate) {
        this.date = duedate;
    }

    // set due date with String
    public void setDate(String duedate) {
        try{
            this.date = ft.parse(duedate);
        } catch (ParseException e) {
            // If the format is wrong it will automatically set due date as current Date
            System.out.println("Incorrect format");
            this.date = new Date();
        }
    }

    // Check if pass due date
    public boolean isDue(){
        Date current = new Date();
        return date.before(current);
    }

    @Override
    public String toString() {
        return getDetail() + " " + date;
    }
}
