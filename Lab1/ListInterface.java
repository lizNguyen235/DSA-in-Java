import java.util.NoSuchElementException;

public interface ListInterface<E> {
    void addFirst(E data);

    void addAfter(E data, Node<E> curr);

    void addLast(E data);

    E removeFirst() throws NoSuchElementException;

    E removeAfter(Node<E> curr) throws NoSuchElementException;

    E removeLast() throws NoSuchElementException;

    E removeCurr(Node<E> curr);

    int size();

    boolean contains(E data);

    void print();

    boolean isEmpty();

    Node<E> getHead();

    E getFirst();

}
