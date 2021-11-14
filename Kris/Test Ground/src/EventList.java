import java.util.LinkedList;

public class EventList {
    private int total;
    private int remain;
    private int passed;

    private LinkedList<TaskEvent> taskEventLinkedList;

    public EventList(){
        taskEventLinkedList = new LinkedList<TaskEvent>();
        passed = remain = total = 0;
    }

    public LinkedList<TaskEvent> getTaskEventLinkedList() {
        return taskEventLinkedList;
    }

    public void sort(){
        LinkedList<TaskEvent> temp = (LinkedList<TaskEvent>) taskEventLinkedList.clone();
        for (TaskEvent e:
             taskEventLinkedList) {
            if(e.isDue()){
                passed++;
                remain--;
                temp.remove(e);
                temp.add(e);
            }
        }
        taskEventLinkedList = temp;
    }

    public int getTotal() {
        return total;
    }

    public int getRemain() {
        return remain;
    }

    public int getPassed() {
        return passed;
    }

    public void clear(){
        taskEventLinkedList.clear();
    }

    public void addTask(String detail){ // O(n)
        taskEventLinkedList.add(remain,(TaskEvent) TaskFactory.createTask("event", detail));
        remain++;
        total++;
    }

    public void addTask(String detail, String date){ // O(n)
        taskEventLinkedList.add(remain, (TaskEvent) TaskFactory.createTask("event",detail, date));
        remain++;
        total++;

    }

    public void removeTask(int index){ // O(n)
        TaskEvent temp = taskEventLinkedList.get(index);
        if(temp.isDue()) passed--;
        else remain--;
        taskEventLinkedList.remove(temp);
        total--;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (TaskEvent temp:
             taskEventLinkedList) {
            str.append(temp.toString()).append("\n");
        }
        return String.valueOf(str);
    }
}
