public class BST<E extends Comparable<E>> {
    protected Node<E> root;

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
        if(root == null) {
            return null;
        }
        return deleteMin(root).getData();
    }

    private Node<E> deleteMin(Node<E> node) {
       if(node.getLeft() == null) {
           return node.getRight();
       }
        node.setLeft(deleteMin(node.getLeft()));
        return node;
    }

    public void delete(E data) {
        if(root == null) {
            return;
        }
        delete(root, data);
    }

    private Node<E> delete(Node<E> node, E data) {
       int compare = data.compareTo(node.getData());
       if(compare > 0) { // data > node.getData()
            node.setRight(delete(node.getRight(), data));
        }
        else if(compare < 0) { // data < node.getData()
            node.setLeft(delete(node.getLeft(), data));
        }
        else { 
            if(node.getLeft() == null) {
                return node.getRight();
            }
            else if(node.getRight() == null) {
                return node.getLeft();
            }
            else {
                node.setData(deleteMin(node.getRight()).getData());
            }
        }
        return node;
    }

    public boolean contains(E data) {
        return contains(root, data);
    }

    private boolean contains(Node<E> node, E data) {
        if(node == null) {
            return false;
        }
        int compare = data.compareTo(node.getData());
        if(compare > 0) {
            return contains(node.getRight(), data);
        }
        else if(compare < 0) {
            return contains(node.getLeft(), data);
        }
        else {
            return true;
        }
    }

    public int Height() {
        return Height(root);
    }

    private int Height(Node<E> node) {
        if(node == null) {
            return -1;
        }
        return 1 + Math.max(Height(node.getLeft()), Height(node.getRight()));
    }
}