package project_ui;

import java.util.LinkedList;

public class TodoList {
    private int unchecked;
    private int checked;
    private int total;

    private final LinkedList<TaskList> todoLinkedList;

    // Constructor
    public TodoList(){
        todoLinkedList = new LinkedList<TaskList>();
        checked = unchecked = total = 0;
    }

    // Add Task
    public void addTask(String detail){ // O(n) where n = unchecked amount
        todoLinkedList.add(unchecked, (TaskList) TaskFactory.createTask("list",detail)); // O(n)
        unchecked++;// O(1)
        total++;// O(1)
    }

    // Overload Task
    public void addTask(String detail, boolean done){ // O(1)
        todoLinkedList.add((TaskList) TaskFactory.createTask(detail,done)); // O(1)
        if(done)checked++;
        else unchecked++;
        total++;
    }

    // isDuplicate
    public boolean isDuplicate(String detail){
        for (TaskList e:
             todoLinkedList) {
            if (e.getDetail().equals(detail)) return true;
        }
        return false;
    }

    // Delete Task
    public void deleteTask(int index){ // O(n)
        TaskList temp = todoLinkedList.get(index); // O(n)
        if(temp != null) {
            if (temp.getStatus()) checked--;  // O(1)
            else unchecked--;
            todoLinkedList.remove(temp); // O(1)
            total--;
        }
    }

    // Get total
    public int getTotal(){
        return total;
    }
    // Get check
    public int getChecked() {
        return checked;
    }
    // Get uncheck
    public int getUnchecked() {
        return unchecked;
    }

    // Get linked list todolist
    public LinkedList<TaskList> getTodoList() {
        return todoLinkedList;
    }
}
