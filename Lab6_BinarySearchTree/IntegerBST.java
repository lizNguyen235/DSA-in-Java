import java.util.LinkedList;
import java.util.Queue;

public class IntegerBST extends BST<Integer> {
    public IntegerBST() {
        super();
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node<Integer> node) {
        if(node == null) {
            return 0;
        }
        if(node.getLeft() == null && node.getRight() == null) {
            return 1;
        }
        return countLeaves(node.getLeft()) + countLeaves(node.getRight());
    }

    public int sum() {
        return sum(root);
    }

    private int sum(Node<Integer> node) {
        if(node == null) {
            return 0;
        }
        return node.getData() + sum(node.getLeft()) + sum(node.getRight());
    }

    public int sumEven() {
        return sumEven(root);
    }

    private int sumEven(Node<Integer> node) {
        if(node == null) {
            return 0;
        }
        if(node.getData() % 2 == 0) {
            return node.getData() + sumEven(node.getLeft()) + sumEven(node.getRight());
        }
        return sumEven(node.getLeft()) + sumEven(node.getRight());
    }

    public int sumEvenKeyAtLeaf() {
        return sumEvenKeyAtLeaf(root);
    }

    private int sumEvenKeyAtLeaf(Node<Integer> node) {
        if(node == null) {
            return 0;
        }
        if(node.getLeft() == null && node.getRight() == null && node.getData() % 2 == 0) {
            return node.getData();
        }
        return sumEvenKeyAtLeaf(node.getLeft()) + sumEvenKeyAtLeaf(node.getRight());
    }

    public void BreadthFirstSearch() {
        BreadthFirstSearch(root);
    }

    private void BreadthFirstSearch(Node<Integer> node) {
        if(node == null) {
            return;
        }
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            Node<Integer> current = queue.poll();
            System.out.print(current.getData() + " ");
            if(current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if(current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
    }
    
}
