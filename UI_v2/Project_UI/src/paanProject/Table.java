package project_ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Table {
    private int day;
    private Date startTime;
    private Date endTime;
    private Task task;
    private SimpleDateFormat sdf;

    // Constructor
    public Table(int day, String startTime, String endTime, String task) {
        sdf =  new SimpleDateFormat("HH:mm");
        this.day = day;
        try {
            this.startTime = sdf.parse(startTime);
            this.endTime = sdf.parse(endTime);
        } catch (ParseException e) {
            System.out.println("Error at table constructor");
            System.out.println(e.getMessage());
        }
        this.task = new Task(task);
    }

    /// Getter

    // Value
    public int getDay() {
        return day;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    // String
    public String getStrStartTime() {
        return sdf.format(startTime);
    }

    public String getStrEndTime() {
        return sdf.format(endTime);
    }

    public String getTask() {
        return task.getDetail();
    }

    public String getStrStartHour(){
        return new SimpleDateFormat("HH").format(startTime);
    }
    public String getStrEndHour(){
        return new SimpleDateFormat("HH").format(endTime);
    }
    public String getStrStartMin(){
        return new SimpleDateFormat("mm").format(startTime);
    }
    public String getStrEndMin(){
        return new SimpleDateFormat("mm").format(endTime);
    }
}
