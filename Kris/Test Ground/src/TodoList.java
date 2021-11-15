
import java.util.LinkedList;

public class TodoList {
    private int unchecked;
    private int checked;
    private int total;

    private LinkedList<TaskList> todoLinkedList;

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
        if(temp.getStatus()) checked--;  // O(1)
        else unchecked--;
        todoLinkedList.remove(temp); // O(1)
        total--;
    }

    // get OBJ task from index
    public TaskList getTask(int index){
        return todoLinkedList.get(index);
    }

    public int getTotal(){
        return total;
    }

    public int getChecked() {
        return checked;
    }

    public int getUnchecked() {
        return unchecked;
    }

    // Display all Task in Todolist Tester
    public void display(){
        System.out.println("Total task: "+total);
        System.out.println("Checked: "+checked);
        System.out.println("Unchecked: "+unchecked);
        System.out.println("Index\t\tStatus\t\tDetail");
        int i = 0;
        for(TaskList t : todoLinkedList){
            System.out.print(i+"\t\t\t");
            System.out.println(t.toString());
            i++;
        }
        System.out.println();
    }

    public LinkedList<TaskList> getTodoList() {
        return todoLinkedList;
    }
}
