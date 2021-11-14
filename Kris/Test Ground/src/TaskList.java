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
    private boolean status;

    // default constructor
    public TaskList() {
        super();
        this.status = false;
    }

    // OVERLOAD: constructor with only String
    public TaskList(String detail) {
        super(detail);
        this.status = false;
    }

    // OVERLOAD: constructor with String and boolean
    public TaskList(String detail, boolean status) {
        super(detail);
        this.status = status;
    }

    // return status of the task
    public boolean getStatus(){ return status;}

    // ToString for testing
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if(status) str.append("Done\t\t");
        else str.append("Not Done\t");
        str.append(getDetail());
        return str.toString();
    }
}
