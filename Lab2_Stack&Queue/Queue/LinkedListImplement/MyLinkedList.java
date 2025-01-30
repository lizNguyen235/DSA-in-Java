package Queue.LinkedListImplement;

import java.util.NoSuchElementException;

public class MyLinkedList<E> implements MyList<E> {
    private Node<E> head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }
    public void addFirst(E item) {
        if(head == null) {
            head = new Node<E>(item, null);
        } else {
            head = new Node<E>(item, head);
        }
        size++;
    }
    public void addAfter(Node<E> curr, E item) {
        if(curr == null) {
            throw new IllegalArgumentException("Node cannot be null");
        }
        Node<E> newNode = new Node<E>(item, curr.getNext());
        curr.setNext(newNode);
        size++;
    }
    public void addLast(E item) {
        if(head == null) {
            addFirst(item);
        }
        else {
            Node<E> curr = head;
            // Traverse to the last node
            while(curr.getNext() != null) {
                curr = curr.getNext();
            }
            curr.setNext(new Node<E>(item, null));
            size++;
        }
    }
    public E removeFirst() {
        if(head == null) {
            throw new NoSuchElementException("List is empty");
        }
        E item = head.getItem();
        head = head.getNext();
        size--;
        return item;
    }
    public E removeAfter(Node<E> curr) {
        if(curr == null || curr.getNext() == null) {
            throw new IllegalArgumentException("Node cannot be null or last node");
        }
        E item = curr.getNext().getItem();
        curr.setNext(curr.getNext().getNext());
        size--;
        return item;
    }
    public E removeLast() {
        if(head == null) {
            throw new NoSuchElementException("List is empty");
        }
        if(head.getNext() == null) {
            return removeFirst();
        }
        Node<E> curr = head;
        while(curr.getNext().getNext() != null) {
            curr = curr.getNext();
        }
        E item = curr.getNext().getItem();
        curr.setNext(null);
        size--;
        return item;
    }
    public void print() {
        Node<E> curr = head;
        while(curr != null) {
            System.out.print(curr.getItem() + " ");
            curr = curr.getNext();
        }
        System.out.println();
    }
    public boolean isEmpty() {
        return head == null;
    }
    public E getFirst() {
        if(head == null) {
            throw new NoSuchElementException("List is empty");
        }
        return head.getItem();
    }
    public Node<E> getHead() {
        return head;
    }
    public void setHead(Node<E> head) {
        this.head = head;
    }
    public int size() {
        return size;
    }
    public boolean contains(E item) {
        Node<E> curr = head;
        while(curr != null) {
            if(curr.getItem().equals(item)) {
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }
    public E removeCurr(Node<E> curr) {
        if(curr == null) {
            throw new IllegalArgumentException("Node cannot be null");
        }
        if(curr == head) {
            return removeFirst();
        }
        Node<E> prev = head;
        while(prev.getNext() != curr) {
            prev = prev.getNext();
        }
        E item = curr.getItem();
        prev.setNext(curr.getNext());
        size--;
        return item;
    }
}