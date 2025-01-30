package Queue.ArrayImplement;
import Queue.MyQueue;

public class ArrayQueue<E> implements MyQueue<E> {
    private int size = 0;
    private E[] data;
    private int front = 0;
    private int rear = -1;
    private int count = 0;
    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        this.size = 1000;
        this.data = (E[]) new Object[this.size];
    }
    public E[] resize(int newSize) {
        @SuppressWarnings("unchecked")
        E[] newData = (E[]) new Object[newSize];
        for (int i = 0; i < this.size; i++) {
            newData[i] = this.data[i];
        }
        return newData;
    }
    public void enQueue(E item) {
        if(count == this.size) {
            this.size *= 2;
            this.data = this.resize(this.size);
        }
        this.rear = (this.rear + 1) % this.size;
        this.data[this.rear] = item;
        count++;
    }
    public E deQueue() {
        if(count == 0) {
            return null;
        }
        E item = this.data[this.front];
        this.data[this.front] = null;
        this.front = (this.front + 1) % this.size;
        count--;
        return item;
    }
    public int size() {
        return this.count;
    }
    public boolean contains(E item) {
        for (int i = 0; i < this.count; i++) {
            if (this.data[i].equals(item)) {
                return true;
            }
        }
        return false;
    }
    public void print() {
        for (int i = 0; i < this.count; i++) {
            System.out.print(this.data[i] + " ");
        }
        System.out.println();
    }
    public boolean isEmpty() {
        return this.count == 0;
    }
    public E getFront() {
        if (this.count == 0) {
            return null;
        }
        return this.data[this.front];
    }
}
