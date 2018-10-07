package collections.implementations.queue;

public interface Queue {

    boolean add(Integer elem); // добавляет элемент в конец очереди
    Integer remove(); // возвращает элемент и удаляет из очереди
    Integer element(); // возвращает элемент и не удаляет из очереди
    int size();
    boolean isEmpty();
    void clear();

    void addAllFrom(Queue q); // добавить все элементы в нашу очередь
    void removeAllTo(Queue q); // удалить с нашей и записать в ту, что передали


}
