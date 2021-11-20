package project_ui;

import java.util.Date;

public class TaskFactory {

    // Create Task for list and event with default
    public static Task createTask(String type, String detail){
        if(type == null){
            return null;
        }
        if(type.equalsIgnoreCase("list")){
            return new TaskList(detail);
        }
        else if (type.equalsIgnoreCase("event")){
            return new TaskEvent(detail);
        }
        return null;
    }

    // Overload: Create TaskList with specific detail and boolean
    public static Task createTask(String detail, boolean done){
        return new TaskList(detail, done);
    }

    // Overload: Create TaskEvent with specific detail and date
    public static Task createTask(String type,String detail, String date){ // this.duedate = "day/month/year hr:m"
        return new TaskEvent(detail, date);
    }

    // Overload: Create TaskEvent with specific detail and date
    public static Task createTask(String detail, Date date){ // this.duedate = "day/month/year hr:m"
        return new TaskEvent(detail, date);
    }


}

