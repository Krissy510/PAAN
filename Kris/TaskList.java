public class TaskList extends Task{
    private boolean done;

    public TaskList() {
        super();
        this.done = false;
    }

    public TaskList(String detail) {
        super(detail);
        this.done = false;
    }

    public TaskList(String detail, boolean done) {
        super(detail);
        this.done = done;
    }

    public boolean isDone(){ return done;}

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if(done) str.append("Done\t\t");
        else str.append("Not Done\t");
        str.append(getDetail());
        return str.toString();
    }
}
