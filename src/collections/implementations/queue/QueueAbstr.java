package collections.implementations.queue;

public abstract class QueueAbstr implements Queue {

    Node head;
    Node tail;
    int size=0;

    public class Node {

        int elem;
        Node prev;

        Node (int elem) {
            this.elem = elem;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }
}
