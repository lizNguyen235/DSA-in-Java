public class IntegerLinkedList extends MyLinkedList<Integer> {
    public IntegerLinkedList() {}

    public int countEven() {
        int count = 0;
        Node<Integer> curr = getHead();
        while(curr != null) {
            if(curr.getItem() % 2 == 0) {
                count++;
            }
            curr = curr.getNext();
        }
        return count;
    }

    public int countPrime() {
        int count = 0;
        Node<Integer> curr = getHead();
        while(curr != null) {
            if(isPrime(curr.getItem())) {
                count++;
            }
            curr = curr.getNext();
        }
        return count;
    }
    public boolean isPrime(int n) {
        if(n <= 1) {
            return false;
        }
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public void addFirstEven(int item) {
        Node<Integer> curr = getHead();
        while(curr != null) {
            if(curr.getItem() % 2 == 0) {
                addAfter(curr, item);
                return;
            }
            curr = curr.getNext();
        }
    }
    public int findMax() {
        if(isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        int max = getFirst();
        Node<Integer> curr = getHead();
        while(curr != null) {
            if(curr.getItem() > max) {
                max = curr.getItem();
            }
            curr = curr.getNext();
        }
        return max;
    }
    public void ReserveList() {

        Node<Integer> curr = getHead();
        Node<Integer> prev = null;
        Node<Integer> next = null;
        while(curr != null) {
           next = curr.getNext();
           curr.setNext(prev);
           prev = curr;
           curr = next;
        }
        setHead(prev);
    }
    public void sort() {
        for(Node<Integer> node = getHead(); node != null; node = node.getNext()) {
            for(Node<Integer> curr = node.getNext(); curr != null; curr = curr.getNext()) {
                if(node.getItem() > curr.getItem()) {
                    int temp = node.getItem();
                    node.setItem(curr.getItem());
                    curr.setItem(temp);
                }
            }
        }
    }
    public static void main(String[] args) {
        IntegerLinkedList list = new IntegerLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(5);
        list.addFirst(6);
        list.addFirst(7);
        list.addFirst(8);
        list.addFirst(9);
        list.addFirst(10);
        list.print();
        System.out.println("Reserve List: ");
        list.ReserveList();
        list.print();
        list.sort();
        list.print();
    }
}
