public class BST<E extends Comparable<E>> {
    private Node<E> root;

    public BST() {
        this.root = null;
    }
    
    public void insert(E data) {
        if(root == null) {
            root = new Node<E>(data);
            return;
        }
        insert(root, data);
    }

   private void insert(Node<E> node, E data) {
        int compare = data.compareTo(node.getData());
        if(compare > 0) { // data > node.getData()
            if(node.getRight() == null) {
                node.setRight(new Node<E>(data));
                return;
            }
            insert(node.getRight(), data);
        }
        else if(compare < 0) { // data < node.getData()
            if(node.getLeft() == null) {
                node.setLeft(new Node<E>(data));
                return;
            }
            insert(node.getLeft(), data);
        }
        else {
            return;
        }
    }

    public void InOrder() {
        InOrder(root);
    }

    private void InOrder(Node<E> node) {
        if(node == null) {
            return;
        }
        InOrder(node.getLeft());
        System.out.println(node.getData());
        InOrder(node.getRight());
    }

    public void PreOrder() {
        PreOrder(root);
    }

    private void PreOrder(Node<E> node) {
        if(node == null) {
            return;
        }
        System.out.println(node.getData());
        PreOrder(node.getLeft());
        PreOrder(node.getRight());
    }

    public void PostOrder() {
        PostOrder(root);
    }

    private void PostOrder(Node<E> node) {
        if(node == null) {
            return;
        }
        PostOrder(node.getLeft());
        PostOrder(node.getRight());
        System.out.println(node.getData());
    }

    public E min() {
        return min(root);
    }

    private E min(Node<E> node) {
        if(node.getLeft() == null) {
            return node.getData();
        }
        return min(node.getLeft());
    }

    public E max() {
        return max(root);
    }

    private E max(Node<E> node) {
        if(node.getRight() == null) {
            return node.getData();
        }
        return max(node.getRight());
    }

    public boolean search(E data) {
        return search(root, data);
    }

    private boolean search(Node<E> node, E data) {
        if(node == null) {
            return false;
        }
        int compare = data.compareTo(node.getData());
        if(compare > 0) {
            return search(node.getRight(), data);
        }
        else if(compare < 0) {
            return search(node.getLeft(), data);
        }
        else {
            return true;
        }
    }

    public E deleteMin() {
        return deleteMin(root);
    }

    private E deleteMin(Node<E> node) {
        if(node.getLeft().getLeft() == null) {
            E data = node.getLeft().getData();
            node.setLeft(node.getLeft().getRight());
            return data;
        }
        return deleteMin(node.getLeft());
    }

    public void delete(E data) {
        delete(root, data);
    }

    private void delete(Node<E> node, E data) {
       int compare = data.compareTo(node.getData());
       if(compare > 0) { // data > node.getData()
            delete(node.getRight(), data);
        }
        else if(compare < 0) { // data < node.getData()
            delete(node.getLeft(), data);
        }
        else { 
            if(node.getLeft() == null) {
                node = node.getRight();
            }
            else if(node.getRight() == null) {
                node = node.getLeft();
            }
            else {
                node.setData(deleteMin(node.getRight()));
            }
        }
    }


    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(1);
        bst.insert(-1);
        bst.insert(8);
        bst.insert(26);
    }
}