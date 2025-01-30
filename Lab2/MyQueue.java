public class MyQueue<E> implements QueueInterface<E> {
    Node<E> front;
    Node<E> tail;
    int numNode;

    public void enQueue(E item) {
        if (isEmpty()) {
            front = new Node<E>(item, front);
            tail = front;
            numNode++;
        } else {
            Node<E> tmp = front;
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            tmp.setNext(new Node<E>(item, tmp.getNext()));
            tail = tmp;
            numNode++;
        }
    }

    public boolean isEmpty() {
        return numNode == 0;
    }

    public int size() {
        return numNode;
    }

    public boolean contains(E item) {
        for (Node<E> tmp = tail; tmp != null; tmp = tmp.getNext()) {
            if (tmp.getData().equals(item)) {
                return true;
            }
        }
        return false;
    }

    public E getFront() {
        return front.getData();
    }

    public E deQueue() {
        E tmp = front.getData();
        front = front.getNext();
        numNode--;
        return tmp;
    }

    public void print() {
        for (Node<E> tmp = front; tmp != null; tmp = tmp.getNext()) {
            System.out.print(tmp.getData() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        System.out.println(queue.deQueue());
        queue.print();

    }

}
