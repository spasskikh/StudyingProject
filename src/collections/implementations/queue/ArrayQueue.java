package collections.implementations.queue;

public class ArrayQueue implements Queue {

    int [] array;
    int size = 0;

    @Override
    public boolean add(Integer elem) {
        size++;
        if (size==0) {
            int [] array = new int [size];
            array [0] = elem;
        }
        else {
            int [] tech = new int [size];
            for (int i = 0 ; i<size-1 ; i++) {
                tech[i] = array[i];
            }
            tech [size-1] = elem;
            array = new int [size];
            array = tech;
        }
        return true;
    }

    @Override
    public Integer remove() {
        if (size==0) {
            System.out.println("No elements");
            return null;
        }
        else {
            int element = array [0];
            size--;
            int [] tech = new int [size];
            for (int i = 0 ; i<size ; i++) {
                tech [i] = array [i+1];
            }
            array = new int [size];
            array = tech;
            return element;
        }
    }

    @Override
    public Integer element() {
        if (isEmpty()) {
            System.out.println("No elements.");
            return null;
        }
        else return array[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void clear() {
        array = null;
        size = 0;
    }

    @Override
    public void addAllFrom(Queue q) {
        while (!q.isEmpty()) {
            add(q.remove());
        }
    }

    @Override
    public void removeAllTo(Queue q) {
        q.addAllFrom(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        try {
            for (int i = 0 ; i<size-1 ; i++) {
                sb.append(array[i]+", ");
            }
            sb.append(array[size-1]+"]");

        } catch (IndexOutOfBoundsException ex) {
            sb.append("]");
        }

        return sb.toString();
    }
}
