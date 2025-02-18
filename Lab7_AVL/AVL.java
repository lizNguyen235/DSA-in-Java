public class AVL<E extends Comparable<E>> {
   protected Node<E> root;

    public AVL() {
        this.root = null;
    }

    private int height(Node<E> node) {
        if(node == null) {
            return -1;
        }
        return node.getHeight();
    }

    private Node<E> leftRotate(Node<E> node) {
        Node<E> temp = node.getRight();
        node.setRight(temp.getLeft());
        temp.setLeft(node);
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        temp.setHeight(1 + Math.max(height(temp.getLeft()), height(temp.getRight())));
        return temp;
    }
    private Node<E> rightRotate(Node<E> node) {
        Node<E> temp = node.getLeft();
        node.setLeft(temp.getRight());
        temp.setRight(node);
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        temp.setHeight(1 + Math.max(height(temp.getLeft()), height(temp.getRight())));
        return temp;
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
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        node = rebalance(node);
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
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        node = rebalance(node);
        return node;
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

    private int balance(Node<E> node) {
        return height(node.getLeft()) - height(node.getRight());
    }
    private Node<E> rebalance(Node<E> node) {
        if(balance(node) > 1) {
            if(balance(node.getLeft()) < 0) {
                node.setLeft(leftRotate(node.getLeft()));
            }
            node = rightRotate(node);
        }
        else if(balance(node) < -1) {
            if(balance(node.getRight()) > 0) {
                node.setRight(rightRotate(node.getRight()));
            }
            node = leftRotate(node);
        }
        return node;
    }
}
