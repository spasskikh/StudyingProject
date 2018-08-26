package collections.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class ToDoListLL {

    private LinkedList<String> toDoList = new LinkedList<>();

    public void addToList(String str) {
//        toDoList.add(str);
        addAlphobetical(str);
    }

    private boolean addAlphobetical(String task) {
        ListIterator<String> listIter = toDoList.listIterator();
        while (listIter.hasNext()) {
            int compare = listIter.next().compareTo(task);
            if (compare == 0) {
                System.out.println("Task already exist in the list.");
                return true;
            } else if (compare > 0) {
                listIter.previous();
                listIter.add(task);
                return true;
            }
        }
        toDoList.add(task);
        return true;
    }

    public void addToListAtPosition(int index, String task) {
        toDoList.add(index, task);
    }

    public void printToDoList() {
        Iterator<String> iterator = toDoList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void changeTask(int index, String task) {
        toDoList.set(index, task);
    }

    public void removeTaskAtIndex(int index) {
        toDoList.remove(index);
    }

    public void removeTask(String task) {
        toDoList.remove(task);
    }

    public int getPriority(String task) {
        return toDoList.indexOf(task);
    }

}
