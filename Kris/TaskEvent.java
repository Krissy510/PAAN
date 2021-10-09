import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskEvent extends Task {
    // Due date of the task
    private Date duedate;

    // default constructor
    public TaskEvent(){
        super();
        this.duedate = new Date();
    }

    // OVERLOAD: constructor with only String
    public TaskEvent(String detail) {
        super(detail);
        this.duedate = new Date();
    }

    // OVERLOAD: constructor with String and obj Date
    public TaskEvent(String detail, Date date) {
        super(detail);
        this.duedate = date;
    }

    // OVERLOAD: constructor with String and String Date
    public TaskEvent(String detail, String date) {
        super(detail);
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try{
            this.duedate = ft.parse(date);
        } catch (ParseException e) {
            // If the format is wrong it will automatically set due date as current Date
            System.out.println("Incorrect format");
            this.duedate = new Date();
        }

    }

    // return Obj date
    public Date getDueDate() { return duedate; }

    // set due date with OBJ
    public void setDueDate(Date duedate) {
        this.duedate = duedate;
    }

    // set due date with String
    public void setDueDate(String duedate) {
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try{
            this.duedate = ft.parse(duedate);
        } catch (ParseException e) {
            // If the format is wrong it will automatically set due date as current Date
            System.out.println("Incorrect format");
            this.duedate = new Date();
        }
    }

    // Check if pass due date
    public boolean isDue(){
        Date current = new Date();
        return duedate.before(current);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if(isDue()) str.append("Done\t\t");
        else str.append("Not Done\t");
        str.append(getDetail()).append("\t");
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy  HH:mm");
        str.append(ft.format(duedate));
        return str.toString();
    }
}
