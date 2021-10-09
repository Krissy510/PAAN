public class TaskFactory {
    /*
    Creating task require detail : String
    Because every method in TaskFactory will call
    this.detail = detail
     */

    // TaskList
    public static TaskList getTaskList(String detail){ // done = false
        return new TaskList(detail);
    }
    public static TaskList getTaskList(String detail, boolean done){ // this.done = done
        return new TaskList(detail, done);
    }

    // TaskEvent
    public static TaskEvent getTaskEvent(String detail, String date){ // duedate = (Current Date)
        return new TaskEvent(detail, date);
    }
    /// NOTE: hr -> 24Hrs format
    public static TaskEvent getTaskEvent(String detail){ // this.duedate = "day/month/year hr:m"
        return new TaskEvent(detail);
    }
}
