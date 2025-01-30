import java.util.*;

public class BST {
    Node root;
    Queue<Integer> q = new LinkedList<>();

    // them vao cay
    private Node insert(Node x, Integer value) {
        if (x == null) {
            return new Node(value);
        }
        int cmp = x.value.compareTo(value);
        if (cmp > 0) {
            x.left = insert(x.left, value);
        } else if (cmp < 0) {
            x.right = insert(x.right, value);
        } else {
            x.value = value;
        }
        return x;
    }

    public void insert(Integer value) {
        root = insert(root, value);
    }

    // duyet cay
    public void inOrder(Node x) { // LNR
        if (x != null) {
            inOrder(x.left);
            System.out.print(x.value + " ");
            inOrder(x.right);
        }
    }

    public void preOrder(Node x) { // NLR
        if (x != null) {
            System.out.print(x.value + " ");
            preOrder(x.left);
            preOrder(x.right);
        }
    }

    public void postOrder(Node x) { // LRN
        if (x != null) {
            postOrder(x.left);
            postOrder(x.right);
            System.out.print(x.value + " ");
        }
    }

    public void printDesc(Node x) { // RNL
        if (x != null) {
            printDesc(x.right);
            System.out.print(x.value + " ");
            printDesc(x.left);
        }
    }

    // tim kiem phan tu trong cay

    private boolean Search(Node x, Integer value) {
        if (x == null) {
            return false;
        }
        int cmp = x.value.compareTo(value);
        if (cmp > 0) {
            return Search(x.left, value);
        } else if (cmp < 0) {
            return Search(x.right, value);
        } else {
            return true;
        }
    }

    public boolean Search(Integer value) {
        return Search(root, value);
    }
    // tim min max cua cay

    private Integer min(Node x) {
        if (x.left == null) {
            return x.value;
        }
        return min(x.left);
    }

    public Integer min() {
        return min(root);
    }

    private Integer max(Node x) {
        if (x.right == null) {
            return x.value;
        }
        return max(x.right);
    }

    public Integer max() {
        return max(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        return x;
    }

    private Node deleteMax(Node x) {

        if (x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        return x;
    }

    public void deleteMax() {
        deleteMax(root);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node delete(Node x, Integer value) {
        int cmp = x.value.compareTo(value);
        if (cmp > 0) {
            x.left = delete(x.left, value);
        } else if (cmp < 0) {
            x.right = delete(x.right, value);
        } else {
            if (x.right == null)
                return x.left;
            if (x.left == null)
                return x.right;
            x.value = min(x.right);
            x.right = deleteMin(x.left);
        }
        return x;
    }

    public void delete(Integer value) {
        root = delete(root, value);
    }

    public Node deletePre(Node x, Integer value) {
        int cmp = x.value.compareTo(value);
        if (cmp > 0) {
            x.left = deletePre(x.left, value);
        } else if (cmp < 0) {
            x.right = deletePre(x.right, value);
        } else {
            x.value = max(x.left);
            x.left = deleteMax(x.left);
        }
        return x;
    }

    private int height(Node x) {
        if (x == null) {
            return -1;
        }
        return 1 + Math.max(height(x.left), height(x.right));
    }

    public int height() {
        return height(root);
    }

    private int sum(Node x) {
        if (x == null) {
            return 0;
        }
        return sum(x.left) + sum(x.right) + x.value;
    }

    public int sum() {
        return sum(root);
    }

    private int sumEven(Node x) {
        if (x == null) {
            return 0;
        }
        if (x.value % 2 == 0) {
            return x.value + sumEven(x.left) + sumEven(x.right);
        } else {
            return sumEven(x.left) + sumEven(x.right);
        }
    }

    public int sumEven() {
        return sumEven(root);
    }

    private int countLeaves(Node x) {
        if (x != null) {
            if (x.left == null && x.right == null) {
                return 1;
            } else {
                return countLeaves(x.left) + countLeaves(x.right);
            }
        }
        return 0;

    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int sumEvenKeysAtLeaves(Node x) {
        if (x != null) {
            if (x.left == null && x.right == null && x.value % 2 == 0) {
                return x.value + sumEvenKeysAtLeaves(x.left) + sumEvenKeysAtLeaves(x.right);
            } else {
                return sumEvenKeysAtLeaves(x.left) + sumEvenKeysAtLeaves(x.right);
            }
        }
        return 0;
    }

    public int sumEvenKeysAtLeaves() {
        return sumEvenKeysAtLeaves(root);
    }

    // private void bfs(Node x) {
    //     if (x != null) {
    //         q.offer(x.value);
    //         q.peek().
    //     }
    // }

    // public void bfs() {
    //     bfs(root);
    // }
}
