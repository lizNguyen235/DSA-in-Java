package Stack.LinkedlistImplement;

import Stack.MyStack;

public class LinkedListStack<E> implements MyStack<E> {
    private MyLinkedList<E> list;

    public LinkedListStack() {
        this.list = new MyLinkedList<E>();
    }
    public void push(E item) {
        this.list.addFirst(item);
    }
    public E pop() {
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
    public E getPeek() {
        return this.list.getFirst();
    }
}
