package Recursion.Ex4;

public class AddSortedLinkedList extends MyLinkedList<Integer> {
    public void add(int item) {
       if(isEmpty()) {
           addFirst(item);
           return;
       }
        Node<Integer> curr = getHead();
        insert(curr, item);
    }
    public void insert(Node<Integer> curr, int item) {
        if(curr.getNext() == null) {
            addAfter(curr, item);
            return;
        }
        if(curr.getNext().getItem() > item) {
            addAfter(curr, item);
            return;
        }
        insert(curr.getNext(), item);
    }
    public int countEven() {
        return countEven(getHead());
    }
    public int countEven(Node<Integer> curr) {
       if(curr.getNext() == null) {
           return curr.getItem() % 2 == 0 ? 1 : 0;
       }
        return (curr.getItem() % 2 == 0 ? 1 : 0) + countEven(curr.getNext());
    }
    public int sum() {
        return sum(getHead());
    }
    public int sum(Node<Integer> curr) {
        if(curr.getNext() == null) {
            return curr.getItem();
        }
        return curr.getItem() + sum(curr.getNext());
    }
}
