package Queue;

public interface MyQueue<E> {
    void enQueue(E item);
    E deQueue();
    int size();
    boolean contains(E item);
    void print();
    boolean isEmpty();
    E getFront();
}
