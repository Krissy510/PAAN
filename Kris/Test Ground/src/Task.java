public class Task {
    // Task description
    private String detail;

    // default constructor
    public Task() {
        this.detail = "";
    }

    // OVERLOAD: constructor with only String
    public Task(String detail) {
        this.detail = detail;
    }

    // get task Detail
    public String getDetail() {
        return detail;
    }

    // set task detail
    public void setDetail(String detail) {
        this.detail = detail;
    }
}
