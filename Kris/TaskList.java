public class TaskList extends Task{
    /*
    TaskList inherit from Task
    Will already had
    - detail : String
    + Task() : void
        Set details = ""
    + getDetail() : String
    + setDetail(String detail) : void
     */

    // boolean to check if the task already done or not
    private boolean done;

    // default constructor
    public TaskList() {
        super();
        this.done = false;
    }

    // OVERLOAD: constructor with only String
    public TaskList(String detail) {
        super(detail);
        this.done = false;
    }

    // OVERLOAD: constructor with String and boolean
    public TaskList(String detail, boolean done) {
        super(detail);
        this.done = done;
    }

    // set done attr
    public void setDone(boolean done){ this.done = done;}

    // return status of the task
    public boolean isDone(){ return done;}

    // ToString for testing
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if(done) str.append("Done\t\t");
        else str.append("Not Done\t");
        str.append(getDetail());
        return str.toString();
    }
}
