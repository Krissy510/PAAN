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

    public void update(){
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

    public void addTask(String detail){ // O(n)
        taskEventLinkedList.add(remain,(TaskEvent) TaskFactory.createTask("", detail));
        remain++;
        total++;
    }

    public void addTask(String detail, String date){ // O(n)
        taskEventLinkedList.add(remain, (TaskEvent) TaskFactory.createTask(detail, date));
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

    public void display(){
        System.out.println("Total task: "+total);
        System.out.println("Remain: "+remain);
        System.out.println("Passed: "+passed);
        System.out.println("Index\t\tStatus\t\tDetail");
        for(int i =0; i < total; i++){
            System.out.print(i+"\t\t\t");
            System.out.println(taskEventLinkedList.get(i).toString());
        }
    }
}
