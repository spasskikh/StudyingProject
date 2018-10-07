package collections.implementations.list;

public interface List {

    void add(Integer elem);
    void add(int index, Integer elem);
    Integer get(int index);
    void set(int index, Integer elem);
    Integer remove(int index);

    List sublist(int indexFrom, int indexTo);

    boolean isEmpty();
    int size();
    int indexof(Integer elem);
    boolean contains(Integer elem);
    void clear();

}
