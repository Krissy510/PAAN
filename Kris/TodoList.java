
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
    public void addTask(String detail){
        todoLinkedList.add(unchecked,new TaskList(detail));
        unchecked++;
        total++;
    }
    // Overload Task
    public void addTask(String detail, boolean done){
        todoLinkedList.add(new TaskList(detail, done));
        if(done)checked++;
        else unchecked++;
        total++;
    }

    // Delete Task
    public void deleteTask(int index){
        if(todoLinkedList.get(index).isDone()) checked--;
        else unchecked--;
        todoLinkedList.remove(index);
        total--;
    }

    // Check Task
    public void check(int index){
        String temp = todoLinkedList.get(index).getDetail();
        todoLinkedList.remove(index);
        todoLinkedList.add(new TaskList(temp, true));
        checked++;
        unchecked--;
    }

    // Uncheck Task
    public void uncheck(int index){
        String temp = todoLinkedList.get(index).getDetail();
        todoLinkedList.remove(index);
        todoLinkedList.add(unchecked, new TaskList(temp));
        checked--;
        unchecked++;
    }

    // Check if Task is checked Tester
    public boolean isCheck(int index){
        return todoLinkedList.get(index).isDone();
    }

    // Check if task exist Tester
    public boolean isExist(int index){
        return index >= 0  && total > 0 && index < total;
    }

    // Check if list is empty Tester
    public boolean isEmpty(){return total == 0;}

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
