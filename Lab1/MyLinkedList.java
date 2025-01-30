import java.util.NoSuchElementException;

public class MyLinkedList<E> {
    protected Node<E> head;
    protected int numNode;

    public void addFirst(E item) {
        head = new Node<E>(item, head);
        numNode++;
    }

    public void addAfter(Node<E> curr, E item) {
        if (curr == null) {
            addFirst(item);
        } else {
            curr.setNext(new Node<E>(item, curr.getNext()));
            numNode++;
        }
    }

    public void addLast(E item) {
        if (head == null) {
            addAfter(head, item);
        } else {
            Node<E> tmp = head;
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            tmp.setNext(new Node<E>(item, tmp.getNext()));
            numNode++;
        }
    }

    public E removeFirst() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("can not element from an empty list");
        } else {
            E tmp = head.getData();
            head = head.getNext();
            numNode--;
            return tmp;
        }
    }

    public E removeAfter(Node<E> curr) throws NoSuchElementException {
        if (curr == null) {
            throw new NoSuchElementException("can not element from an empty list");
        } else {
            E tmp = curr.getData();
            curr.setNext(curr.getNext());
            numNode--;
            return tmp;
        }
    }

    public E removeLast() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("can not element from an empty list");
        } else {
            if (numNode == 1) {
                return removeFirst();
            }
            Node<E> tmp = head;
            while (tmp.getNext().getNext() != null) {
                tmp = tmp.getNext();
            }
            E item = tmp.getNext().getData();
            tmp.setNext(null);
            numNode--;
            return item;
        }
    }

    public int size() {
        return numNode;
    }

    public boolean contains(E item) {
        for (Node<E> curr = head; curr != null; curr = curr.getNext()) {
            if (curr.getData().equals(item)) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        for (Node<E> tmp = head; tmp != null; tmp = tmp.getNext()) {
            System.out.print(tmp.getData() + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return numNode == 0;
    }

    public Node<E> getHead() {
        return head;
    }

    public E getFirst() {
        return head.getData();
    }

    public E removeCurr(Node<E> curr) throws NoSuchElementException {
        if (curr == null) {
            throw new NoSuchElementException("can not element from an empty list");
        }
        E tmp = curr.getData();
        for (Node<E> I = head; I != null; I = I.getNext()) {
            if (I.getNext() == curr) {
                I.setNext(curr.getNext());
                return tmp;
            }
        }
        return tmp;
    }

}