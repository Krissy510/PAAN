package project_ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskEvent extends Task{
    // Due date of the task
    private Date date;
    private final SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm");

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

    // Get time
    // 0 -> 24 hrs
    // 1 -> 12 hrs
    public String getTime(int type){
        SimpleDateFormat time;
        if(type == 0)
            time = new SimpleDateFormat("HH:mm");
        else
            time = new SimpleDateFormat("hh:mm a");
        return time.format(date);
    }

    /// Get date
    // String
    public String getStrDate(){
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

    // Date Obj
    public Date getDate(){
        return date;
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
        return getDetail() + " " + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(date);
    }
}
