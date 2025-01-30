
public class MyList extends MyLinkedList<Integer> {
    public MyList() {
        super();
    }

    public int countEventNumber() {
        int count = 0;
        for (Node<Integer> tmp = getHead(); tmp != null; tmp = tmp.getNext()) {
            if (tmp.getData() % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int data) {
        if (data < 2)
            return false;
        for (int i = 2; i < data; i++) {
            if (data % i == 0)
                return false;
        }
        return true;
    }

    public int countPrimeNumber() {
        int count = 0;
        for (Node<Integer> tmp = getHead(); tmp != null; tmp = tmp.getNext()) {
            if (isPrime(tmp.getData()))
                count++;
        }
        return count;

    }

    public int findMax() {
        int max = getFirst();
        for (Node<Integer> tmp = getHead(); tmp != null; tmp = tmp.getNext()) {
            if (max < tmp.getData())
                max = tmp.getData();
        }
        return max;
    }

    public void reverseList() {
        if (size() == 1 || size() == 0)
            return;
        else {
            Node<Integer> pre = null;
            Node<Integer> next = null;
            Node<Integer> curr = head;
            while (curr.getNext() != null) {
                next = curr.getNext();
                curr.setNext(pre);
                pre = curr;
                curr = next;
            }
            head = curr;
            curr.setNext(pre);
        }
    }

    public static void main(String[] args) {
        MyList List = new MyList();
        List.addFirst(1);
        List.addFirst(2);
        List.addFirst(3);
        List.addFirst(4);
        List.addFirst(5);
        List.addFirst(6);
        List.addFirst(7);
        List.print();
        List.reverseList();
        System.out.println();
        List.print();

    }
}
