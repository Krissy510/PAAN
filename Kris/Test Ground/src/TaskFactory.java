import java.util.Date;

public class TaskFactory {
    /*
    Creating task require detail : String
    Because every method in TaskFactory will call
    this.detail = detail
     */

    // TaskList

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

    public static Task createTask(String detail, boolean done){
        return new TaskList(detail, done);
    }

    /// NOTE: hr -> 24Hrs format
    public static Task createTask(String type,String detail, String date){ // this.duedate = "day/month/year hr:m"
        return new TaskEvent(detail, date);
    }

    public static Task createTask(String detail, Date date){ // this.duedate = "day/month/year hr:m"
        return new TaskEvent(detail, date);
    }


}

