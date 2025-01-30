package Queue.LinkedListImplement;
import Queue.MyQueue;
public class LinkedListQueue<E> implements MyQueue<E> {
    private MyLinkedList<E> list;
    public LinkedListQueue() {
        this.list = new MyLinkedList<>();
    }
    public void enQueue(E item) {
        this.list.addLast(item);
    }
    public E deQueue() {
        return this.list.removeFirst();
    }
    public int size() {
        return this.list.size();
    }
    public boolean contains(E item) {
        return this.list.contains(item);
    }
    public void print() {
        this.list.print();
    }
    public boolean isEmpty() {
        return this.list.isEmpty();
    }
    public E getFront() {
        return this.list.getFirst();
    }
    
}
