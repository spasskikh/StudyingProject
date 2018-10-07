package collections.implementations.set;

import java.util.List;

public interface Set <E> {

    boolean add(E element);
    boolean contains(E element);
    boolean remove(E element);

    List<E> toList();

}
