import java.util.Scanner;

public class TodoListTester {

    public static void menu(){
        System.out.println("MENU:");
        System.out.println("'+' to add a task");
        System.out.println("'-' to delete a task");
        System.out.println("'#' to check a task");
        System.out.println("'!' to uncheck a task");
        System.out.println("'d' to display all task");
        System.out.println("'q' to quit");
        System.out.print("Input: ");
    }

    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);
        char choice;
        int index;
        while(true){
            menu();
            choice = scanner.next().charAt(0);
            System.out.println();
            switch (choice){
                case '+':
                    System.out.print("Detail: ");
                    String detail = scanner.next();
                    todoList.addTask(detail);
                    System.out.println("Task added\n");
                    todoList.display();
                    break;
                case '-':
                    System.out.print("Index: ");
                    index = scanner.nextInt();
                    if(todoList.isExist(index)){
                        todoList.deleteTask(index);
                        System.out.println("Task deleted\n");
                        todoList.display();
                    }
                    else System.out.println("Task doesn't exist\n");
                    break;
                case '#':
                    System.out.print("Index: ");
                    index = scanner.nextInt();
                    if(todoList.isExist(index)){
                        if(!todoList.isCheck(index)){
                            todoList.check(index);
                            System.out.println("Task checked\n");
                            todoList.display();
                        }
                        else{
                            System.out.println("Task is already checked\n");
                        }
                    }
                    else  System.out.println("Task doesn't exist\n");
                    break;
                case '!':
                    System.out.print("Index: ");
                    index = scanner.nextInt();
                    if(todoList.isExist(index)){
                        if(todoList.isCheck(index)){
                            todoList.uncheck(index);
                            System.out.println("Task unchecked\n");
                            todoList.display();
                        }
                        else{
                            System.out.println("Task is already unchecked\n");
                        }
                    }
                    else System.out.println("Task doesn't exist\n");
                    break;
                case 'd':
                    if(todoList.isEmpty()) System.out.println("List is empty\n");
                    else todoList.display();
                    break;
                case 'q':
                    return;
            }
        }
    }
}
