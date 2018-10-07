package collections.implementations.stack;

public class LinkedStack implements Stack {

    int size = 0;
    Node head;

    public class Node {

        Integer element;
        Node next;

        Node (Integer element) {
            this.element = element;
        }
    }

    @Override
    public boolean push(int elem) {
        Node node = new Node (elem);
        if (head == null) {
            head = node;
            size++;
        }
        else {
            Node tech = new Node (elem);
            tech.next = head;
            head = tech;
            size++;
        }
        return true;
    }

    @Override
    public boolean empty() {
        return size==0;
    }

    @Override
    public Integer pop() {
        int i = head.element;
        Node tech = head.next;
        head.next = head.next.next;
        head = tech;
        size--;
        return i;
    }

    @Override
    public Integer peek() {

        return head.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node tech = head;
        for (int i = 0;i<size-1;i++) {
            sb.append(tech.element+", ");
            tech = tech.next;
        }
        sb.append(tech.element+"]");
        return sb.toString();
    }
}