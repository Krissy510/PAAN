public class TaskFactory {
    public static TaskList getTaskList(String detail){
        return new TaskList(detail);
    }
    public static TaskList getTaskList(String detail, boolean done){ // Overload
        return new TaskList(detail, done);
    }
}
