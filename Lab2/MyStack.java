import java.util.NoSuchElementException;

public class MyStack<E> implements StackInterface<E> {
    Node<E> top;
    int numNode;

    public void push(E data) {
        top = new Node<E>(data, top);
        numNode++;
    }

    public E pop() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("haha ngu");
        }
        E tmp = top.getData();
        top = top.getNext();
        numNode--;
        return tmp;
    }

    public int size() {
        return numNode;
    }

    public boolean isEmpty() {
        return numNode == 0;
    }

    public E peek() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("haha");
        }
        return top.getData();
    }

    public boolean contains(E data) {
        for (Node<E> curr = top; curr != null; curr = curr.getNext()) {
            if (curr.getData().equals(data))
                return true;
        }
        return false;
    }

    public void print() {
        for (Node<E> curr = top; curr != null; curr = curr.getNext()) {
            System.out.print(curr.getData() + " ");
        }
    }

    public static void main(String[] args) {
        MyStack<Integer> st = new MyStack<>();
        st.push(5);
        st.push(6);
        System.out.println(st.contains(6));
        st.print();
    }
}
