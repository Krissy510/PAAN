package project_ui;

import java.util.Date;
import java.util.LinkedList;

public class EventList {
    private int total;
    private int remain;
    private int passed;

    private LinkedList<TaskEvent> taskEventLinkedList;

    // Default constructor
    public EventList(){
        taskEventLinkedList = new LinkedList<TaskEvent>();
        passed = remain = total = 0;
    }

    // Add task
    public void addTask(String detail, String date){ // O(n)
        taskEventLinkedList.add(remain, (TaskEvent) TaskFactory.createTask("event",detail, date));
        remain++;
        total++;

    }

    // Remove task
    public void removeTask(int index){ // O(n)
        TaskEvent temp = taskEventLinkedList.get(index);
        if(temp.isDue()) passed--;
        else remain--;
        taskEventLinkedList.remove(temp);
        total--;
    }

    // Sort
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

    // isDuplicate
    public boolean isDuplicate(String detail, String time){
        for (TaskEvent e:
                taskEventLinkedList) {
            if(e.getTime(0).equals(time) && e.getDetail().equals(detail)) return true;
        }
        return false;
    }

    // Get linked list
    public LinkedList<TaskEvent> getTaskEventLinkedList() {
        return taskEventLinkedList;
    }
    // Get total
    public int getTotal() {
        return total;
    }
    // Get remain
    public int getRemain() {
        return remain;
    }
    // Get passed
    public int getPassed() {
        return passed;
    }
    // Get clear
    public void clear(){
        taskEventLinkedList.clear();
    }
    // Get TaskEvent from LinkedList
    public TaskEvent getOBJTask(int index){
        return taskEventLinkedList.get(index);
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
