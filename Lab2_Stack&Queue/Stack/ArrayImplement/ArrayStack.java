package Stack.ArrayImplement;
import Stack.MyStack;
public class ArrayStack<E> implements MyStack<E> {
    private int size = 0;
    private E[] data;
    @SuppressWarnings("unchecked")
    public ArrayStack() {
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
    public void push(E item) {
        if (this.size == this.data.length) {
           this.size *= 2;
           this.data = this.resize(this.size);
        }
        this.data[this.size++] = item;
    }
    public E pop() {
        if (this.size == 0) {
            return null;
        }
        E item = this.data[--this.size];
        this.data[this.size] = null;
        return item;
    }
    public int size() {
        return this.size;
    }
    public boolean contains(E item) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i].equals(item)) {
                return true;
            }
        }
        return false;
    }
    public void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.data[i] + " ");
        }
        System.out.println();
    }
    public boolean isEmpty() {
        return this.size == 0;
    }
    public E getPeek() {
        if (this.size == 0) {
            return null;
        }
        return this.data[this.size - 1];
    }
}
