package collections.list;

import java.util.ArrayList;
import java.util.List;

public class ToDoListAL {

    private List<String> toDoList = new ArrayList<>();

    public void addToList(String str) {
        toDoList.add(str);
    }

    public void addToListAtPosition(int index, String task) {
        toDoList.add(index, task);
    }

    public void printToDoList() {
        for (int i = 0; i<toDoList.size(); i++) {
            System.out.println(i+1+") "+toDoList.get(i));
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
