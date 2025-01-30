public class IntLinkedList implements ListInterface {
    private Node head;

    public void addFirst(int data) {
        head = new Node(data, head);
    }

    public boolean addLast(int data) {
        Node tmp;
        if (head == null) {
            addFirst(data);
            return true;
        }
        for (tmp = head; tmp.getNext() != null; tmp = tmp.getNext())
            ;
        tmp.setNext(new Node(data, tmp.getNext()));
        return true;
    }

    public boolean removeAt(int position) {
        int index = 1;
        if (head == null) {
            return false;
        }
        if (position == 1) {
            head = head.getNext();
            return true;
        }
        for (Node tmp = head; tmp.getNext() != null; tmp = tmp.getNext()) {
            if (position == index + 1) {
                tmp.setNext(tmp.getNext().getNext());
                return true;
            }
            index++;
        }
        return false;
    }

    public int countOdd() {
        int count = 0;
        for (Node tmp = head; tmp != null; tmp = tmp.getNext()) {
            if (tmp.getData() % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    public int searchKey(int key) {
        int index = 1;
        for (Node tmp = head; tmp != null; tmp = tmp.getNext()) {
            if (tmp.getData() == key) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public boolean checkSorted() {
        boolean asc = false;
        boolean dsc = false;
        for (Node curr = head, pre = head; curr != null; curr = curr.getNext()) {
            if (pre.getData() > curr.getData()) {
                asc = true;
            }
            if (pre.getData() < curr.getData()) {
                dsc = true;
            }
            if (asc == dsc && asc == true) {
                return false;
            }
            pre = curr;
        }
        return true;
    }

    public void print() {
        for (Node tmp = head; tmp != null; tmp = tmp.getNext()) {
            System.out.print(tmp.getData() + " ");
        }
    }

    public static void main(String[] args) {
        IntLinkedList list = new IntLinkedList();
        list.addLast(1);
        list.addFirst(2);
        list.addFirst(2);
        System.out.println(list.checkSorted());
        list.print();

    }
}
