package collections.implementations.list;

public class LinkedList implements List {

    Node first;
    Node last;
    int size=0;

    private class Node {

        Node next;
        Node prev;
        Integer elem;

        Node (Integer elem) {
            this.elem = elem;
         }

    }

    @Override
    public void add(Integer elem) {

        if (size == 0) {
            Node tech = new Node (elem);
            first = last = tech;
            first.next = last;
            last.prev = first;
            size++;
        }
        else  {
            Node tech = new Node (elem);
            tech.prev = last;
            last.prev.next = last;
            last.next = tech;
            last = tech;
            size++;
        }
    }

    @Override
    public void add(int index, Integer elem) {

        try {

            if (index>=size||index<0) throw new IndexOutOfBoundsException();

            else if (index == 0) {
                Node tech = new Node(elem);
                tech.next = first;
                first.prev = tech;
                first = tech;
                size++;
            }

            else {
                Node tech = first;
                for (int i = 0 ; i<index; i++) {
                    tech = tech.next;
                }
                Node newElem = new Node(elem);
                newElem.prev = tech.prev;
                newElem.next = tech;
                tech.prev.next = newElem;
                tech.prev = newElem;
                size++;
            }

        }catch (IndexOutOfBoundsException ex) {
            System.out.println("Index out of bounds exception.");
        }

    }

    @Override
    public Integer get(int index) {

        try {

            int elem;

            if (index>=size||index<0) throw new IndexOutOfBoundsException();

            else if (index == 0) return elem = first.elem;

            else {
                Node tech = first;
                for (int i = 0 ; i<index; i++) {
                    tech = tech.next;
                }
               return elem = tech.elem;
            }

        }catch (IndexOutOfBoundsException ex) {
            System.out.println("Index out of bounds exception.");
        }
        return null;
    }

    @Override
    public void set(int index, Integer elem) {

        try {

            if (index>=size||index<0) throw new IndexOutOfBoundsException();

            else if (index == 0) {
                Node tech = new Node(elem);
                tech.next = first.next;
                first.next.prev = tech;
                first = tech;
            }

            else if (index == size-1) {
                Node tech = new Node(elem);
                tech.prev = last.prev;
                last.prev.next = tech;
                last = tech;
            }

            else {
                Node tech = first;
                for (int i = 0 ; i<index; i++) {
                    tech = tech.next;
                }

                Node newElem = new Node(elem);
                newElem.prev = tech.prev;
                newElem.next = tech.next;
                tech.prev.next = newElem;
                tech.next.prev = newElem;
            }


        }catch (IndexOutOfBoundsException ex) {
            System.out.println("Index out of bounds exception.");
        }
    }

    @Override
    public Integer remove(int index) {
        try {

            int elem;

            if (index>=size||index<0) throw new IndexOutOfBoundsException();

            else if (index == 0) {
                elem = first.elem;
                first = first.next;
                first.prev = null;
                size--;
                return elem;
            }

            else if (index == size-1) {
                elem = last.elem;
                last = last.prev;
                last.next = null;
                size--;
                return elem;
            }

            else {
                Node tech = first;
                for (int i = 0 ; i<index; i++) {
                    tech = tech.next;
                }
                elem = tech.elem;
                tech.prev.next = tech.next;
                tech.next.prev = tech.prev;
                size--;
                return elem;
            }

        }catch (IndexOutOfBoundsException ex) {
            System.out.println("Index out of bounds exception.");
        }
        return null;
    }

    @Override
    public List sublist(int indexFrom, int indexTo) {
        if (indexFrom>indexTo||indexTo<0||indexTo>=size||indexFrom<0||indexFrom>=size) {
            System.out.println("Wrong parameters.");
            return null;
        }
        else  {
            List ls = new LinkedList();
            Node tech = first;
            for (int i = 0 ; i<indexFrom ; i++) {
                tech = tech.next;
            }
            while (indexFrom<=indexTo) {
                ls.add(tech.elem);
                tech = tech.next;
                indexFrom++;
            }
            return ls;
        }
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexof(Integer elem) {

        boolean contains = false;
        Node tech = first;
        int index = 0;
        while (!contains && index!=size) {
            if (tech.elem == elem) contains = true;
            else {
                tech = tech.next;
                index++;
            }
        }
        if (contains) return index;
        else return index=-1;

    }

    @Override
    public boolean contains(Integer elem) {
        boolean contains = false;
        Node tech = first;
        int index = 0;
        while (!contains && index!=size) {
            if (tech.elem == elem) contains = true;
            else {
                tech = tech.next;
                index++;
            }
        }
        return contains;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("[");
            Node tech = first;
            for (int i = 0 ; i<size-1 ; i++) {
                sb.append(tech.elem+", ");
                tech = tech.next;
            }
            sb.append(tech.elem+"]");

            sb.append(" [");
            Node tech2 = last;
            for (int i = 0 ; i<size-1 ; i++) {
                sb.append(tech2.elem+", ");
                tech2 = tech2.prev;
            }
            sb.append(tech2.elem+"]");

        } catch (NullPointerException ex) {
        }
        return sb.toString();
    }
}
