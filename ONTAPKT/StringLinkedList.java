public class StringLinkedList {
    private Node<String> head;

    public boolean addFirst(String text) {
        for (Node<String> tmp = head; tmp != null; tmp = tmp.getNext()) {
            if (tmp.getData().equals(text)) {
                return false;
            }
        }
        head = new Node<String>(text, head);
        return true;
    }

    public boolean updateString(String text, int pos) {
        if (pos < 0) {
            return false;
        }

        for (Node<String> tmp = head; tmp != null; tmp = tmp.getNext()) {
            int count = 0;
            if (count == pos - 1) {
                tmp.setNext(new Node<String>(text, tmp.getNext().getNext()));
                return true;
            }
            count++;
        }
        return false;

    }

    public void print() {
        for (Node<String> tmp = head; tmp != null; tmp = tmp.getNext()) {
            System.out.print(tmp.getData() + " ");
        }
    }

    public static int abc(int[] a, int k) {
        if (k == 0) {
            if (a[k] % 3 == 0) {
                return a[k];
            } else {
                return 1;
            }
        }
        if (a[k] % 3 == 0) {
            return a[k] * abc(a, k - 1);
        } else {
            return 1 * abc(a, k - 1);
        }
    }

    public static void main(String[] args) {
        // StringLinkedList s = new StringLinkedList();
        // System.out.println(s.addFirst("abc"));
        // System.out.println(s.addFirst("fff"));
        // s.addFirst("null");
        // s.updateString("hehe", 2);
        // s.print();
        int a[] = { 1, 2, 3, 4, 5, 6 };
        System.out.println(abc(a, 5));

    }
}