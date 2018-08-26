package collections.list;

import java.util.Scanner;

public class ListMain {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
//        ToDoListAL list = new ToDoListAL();
        ToDoListLL list = new ToDoListLL();

        printOut();

        int param = scan.nextInt();
        while (param != 0) {
            switch (param) {
                case 1:
                    System.out.println("Please enter a task to add:");
                    scan.nextLine();
                    list.addToList(scan.nextLine());
                    System.out.println("Please choose an action by typing 0 to 6.");
                    param = scan.nextInt();
                    break;
                case 2:
                    System.out.println("Printing out ToDoList");
                    list.printToDoList();
                    System.out.println("Please choose an action by typing 0 to 6.");
                    param = scan.nextInt();
                    break;
                case 3:
                    System.out.println("Please enter an index to insert");
                    scan.nextLine();
                    int i = scan.nextInt();
                    System.out.println("Please enter a new item");
                    scan.nextLine();
                    list.addToListAtPosition(i, scan.nextLine());
                    System.out.println("Please choose an action by typing 0 to 6.");
                    param = scan.nextInt();
                    break;
                case 4:
                    System.out.println("Please enter a task to remove");
                    scan.nextLine();
                    list.removeTask(scan.nextLine());
                    System.out.println("Please choose an action by typing 0 to 6.");
                    param = scan.nextInt();
                    break;
                case 5:
                    System.out.println("Please enter a task to get priority");
                    scan.nextLine();
                    System.out.println("Task priority is "+list.getPriority(scan.nextLine()));
                    System.out.println("Please choose an action by typing 0 to.");
                    param = scan.nextInt();
                    break;
                case 6:
                    System.out.println("Please enter a position for the task");
                    scan.nextLine();
                    int index = scan.nextInt();
                    System.out.println("Please enter a new task");
                    scan.nextLine();
                    list.changeTask(index,scan.nextLine());
                    System.out.println("Please choose an action by typing 0 to 6.");
                    param = scan.nextInt();
                    break;
                case 0:
                    break;
                default:
                    param = 0;
            }
        }


    }

    private static void printOut() {

        System.out.println("Please, choose an action. Press:\n" +
                "1 to add an item into ToDoList\n" +
                "2 to print out ToDoList\n" +
                "3 to update an existing item\n" +
                "4 to remove an item from ToDoList\n" +
                "5 to get task priority or number in the list\n" +
                "6 to add a new item at the specific position\n" +
                "press 0 to exit\n\n" +
                "AFTER CHOOSING AN OPTION PLEASE PRESS AN ENTER"
        );

    }
}
