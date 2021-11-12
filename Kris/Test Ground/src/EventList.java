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
        int loop = total;
        for(int i = 0; i < loop; i++ ){
            TaskEvent temp = taskEventLinkedList.get(i); // O(n)
            if(temp.isDue()){
                taskEventLinkedList.remove(temp); // O(1)
                taskEventLinkedList.add(temp); // O(1)
                i--;
                loop--;
            }
        }
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
