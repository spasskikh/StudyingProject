package collections.implementations.stack;

public class ArrayStack implements Stack {

    int size = 0;
    int [] array;

    @Override
    public boolean push(int elem) {
        if (size==0) {
            size++;
            array = new int[size];
            array [0] = elem;
        }

        else {
            size++;
            int [] tech = new int [size];
            for (int i = 0;i<size-1;i++) {
                tech [i] = array [i];
            }
            tech [size-1] = elem;
            array = new int [size];
            array = tech;
        }
        return true;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public Integer pop() {
        int a = array [size-1];
        size--;
        int [] tech = new int [size];
        for (int i = 0 ; i<size ; i++) {
            tech [i] = array [i];
        }

        array = tech;


        return a;
    }

    @Override
    public Integer peek() {
        return array [size-1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        sb.append("["+array [size-1]+", ");
        for (int i = size-1; i > 1;i--) {
            sb.append(array[i-1]+", ");
        }
        sb.append(array[0]+"]");
        return sb.toString();
    }
}