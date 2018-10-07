package collections.implementations.list;

public class ArrayList implements List {

    int size=0;
    int [] array;

    @Override
    public void add(Integer elem) {

        size++;

        if (size==0) {
            int [] array = new int [size];
            array [0] = elem;
        }
        else {
            int [] tech = new int [size];
            for (int i = 0 ; i<size-1 ; i++) {
                tech [i] = array [i];
            }
            tech [size-1] = elem;
            array = new int [size];
            array = tech;
        }
    }

    @Override
    public void add(int index, Integer elem) {

        try {
            if (index<0||index>=size) throw new IndexOutOfBoundsException();

            size++;
            int [] tech = new int[size];
            for (int i = 0 ; i<index ; i++) {
                tech [i] = array [i];
            }
            tech [index] = elem;
            for (int i = index+1; i<size ; i++) {
                tech [i] = array [i-1];
            }

            array = new int [size];
            array = tech;

        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getClass().getName());
        }
    }

    @Override
    public Integer get(int index) {

        try {
            if (index<0||index>size) throw new IndexOutOfBoundsException();
            return array [index];

        }catch (IndexOutOfBoundsException ex) {
            System.out.print(ex.getClass().getName()+":");
            return -1;
        }
    }

    @Override
    public void set(int index, Integer elem) {

        try {
            if (index<0||index>size) throw new IndexOutOfBoundsException();
            array [index] = elem;

        }catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getClass().getName());
        }
    }

    @Override
    public Integer remove(int index) {

        try {
            if (index<0||index>=size) throw new IndexOutOfBoundsException();

            size--;
            int [] tech = new int[size];
            for (int i = 0 ; i<index ; i++) {
                tech [i] = array [i];
            }
            int elem = array [index];
            for (int i = index; i<size ; i++) {
                tech [i] = array [i+1];
            }

            array = new int [size];
            array = tech;
            return elem;

        } catch (IndexOutOfBoundsException ex) {
            System.out.print(ex.getClass().getName()+":");
            return -1;
        }
    }

    @Override
    public List sublist(int indexFrom, int indexTo) {

        if (indexFrom>indexTo||indexTo<0||indexTo>=size||indexFrom<0||indexFrom>=size) {
            System.out.println("Wrong parameters.");
            return null;
        }
        else  {

            List as = new ArrayList();

            while (indexFrom<=indexTo) {
                as.add(get(indexFrom));
                indexFrom++;
            }
            return as;
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
        int i = size;
        int index = 0;
        while (!contains && i!=0) {
            if (array[index]==elem) {
                contains = true;
            }
            else {
                i--;
                index++;
            }
        }
        if (contains) return index;
        else return -1;
    }

    @Override
    public boolean contains(Integer elem) {
        boolean contains = false;
        int i = size;
        int index = 0;
        while (!contains && i!=0) {
            if (array[index]==elem) {
                contains = true;
            }
            else {
                i--;
                index++;
            }
        }
        return contains;
    }

    @Override
    public void clear() {
        array = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0 ; i<size-1 ; i++) {
            sb.append(array[i]+", ");
        }
        sb.append(array[size-1]+"]");
        return sb.toString();
    }
}
