package Queue.ArrayImplement;
import Queue.MyQueue;

public class ArrayQueue<E> implements MyQueue<E> {
    private E[] data;
    private int front = 0;
    private int rear = -1;
    private int count = 0;
    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        this.data = (E[]) new Object[1000];
        this.front = 0;
        this.rear = data.length - 1;
    }
    public E[] resize(int newSize) {
        @SuppressWarnings("unchecked")
        E[] newData = (E[]) new Object[newSize];
        for (int i = 0; i < data.length; i++) {
            newData[i] = this.data[i];
        }
        return newData;
    }
    public void enQueue(E item) {
        if(count == data.length) {
            int size = data.length * 2;
            this.data = resize(size);
        }
        this.rear = (this.rear + 1) % data.length;
        this.data[this.rear] = item;
        count++;
    }
    public E deQueue() {
        if(count == 0) {
            return null;
        }
        E item = this.data[this.front];
        this.data[this.front] = null;
        this.front = (this.front + 1) % data.length;
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
        for (int i = 0; i < data.length; i++) {
            if(this.data[i] == null) {
                continue;
            }
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
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(6);
        queue.enQueue(7);
        queue.enQueue(8);
        queue.enQueue(9);
        queue.print();
        queue.deQueue();
        queue.print();
    }
}
