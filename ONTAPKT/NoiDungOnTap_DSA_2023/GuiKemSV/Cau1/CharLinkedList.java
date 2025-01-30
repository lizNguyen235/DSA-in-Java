public class CharLinkedList implements ListInterface {
    private Node head;

    public CharLinkedList() {
        head = null;
    }

    public Node getHead() {
        return head;
    }

    public void addFirst(char data) {
        head = new Node(data, head);
    }

    public boolean addAfterFirstKey(char data, char key) {
        if (head == null) {
            return false;
        }
        for (Node tmp = head; tmp != null; tmp = tmp.getNext()) {
            if (tmp.getData() == key) {
                tmp.setNext(new Node(data, tmp.getNext()));
                return true;
            }
        }
        return false;
    }

    public int largestCharPostition() {
        if (head == null) {
            return -1;
        }
        int index = 0;
        int max = getHead().getData();
        int pos = 0;
        for (Node tmp = head; tmp != null; tmp = tmp.getNext()) {
            if (max < tmp.getData()) {
                max = tmp.getData();
                index = pos;
            }
            pos++;
        }
        return index;
    }

    public void print() {
        for (Node tmp = head; tmp != null; tmp = tmp.getNext()) {
            System.out.print(tmp.getData() + " ");
        }
    }

    public static void main(String[] args) {
        CharLinkedList list = new CharLinkedList();
        list.addFirst('a');
        list.addFirst('b');
        System.out.println(list.addAfterFirstKey('e', 'b'));
        System.out.println(list.largestCharPostition());
        list.print();
    }
}