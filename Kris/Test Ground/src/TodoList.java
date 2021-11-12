
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
        todoLinkedList.add(unchecked, TaskFactory.getTaskList(detail)); // O(n)
        unchecked++;// O(1)
        total++;// O(1)
    }
    // Overload Task
    public void addTask(String detail, boolean done){ // O(1)
        todoLinkedList.add(TaskFactory.getTaskList(detail,done)); // O(1)
        if(done)checked++;
        else unchecked++;
        total++;
    }

    // Delete Task
    public void deleteTask(int index){ // O(n)
        TaskList temp = todoLinkedList.get(index); // O(n)
        if(temp.isDone()) checked--;  // O(1)
        else unchecked--;
        todoLinkedList.remove(temp); // O(1)
        total--;
    }

    // Check Task
    public void check(int index){ // O(n)
        TaskList temp = todoLinkedList.get(index); // O(n)
        todoLinkedList.remove(temp); // O(1)
        todoLinkedList.add(temp); // O(1)
        checked++;
        unchecked--;
    }

    // Uncheck Task
    public void uncheck(int index){ // O(n)
        TaskList temp = todoLinkedList.get(index); // O(n)
        todoLinkedList.remove(temp); // O(1)
        temp.setDone(false); // O(1)
        todoLinkedList.add(unchecked, temp); // O(n)
        checked--;
        unchecked++;
    }

    // Check if Task is checked Tester
    public boolean isCheck(int index){
        return todoLinkedList.get(index).isDone();
    } // O(n)

    // Check if task exist Tester
    public boolean isExist(int index){
        return index >= 0  && total > 0 && index < total;
    }  // O(1)

    // Check if list is empty Tester
    public boolean isEmpty(){return total == 0;} // O(1)

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
}
