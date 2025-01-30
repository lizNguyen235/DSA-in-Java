public class Test {
    static BST tree = new BST();

    public static void createTree(String strKey) {
        String[] arr = strKey.split(" ");
        for (String i : arr) {
            tree.insert(Integer.parseInt(i));
        }
    }

    public static void main(String[] args) {
        // BST tree = new BST();

        // tree.insert(5);
        // tree.insert(3);
        // tree.insert(7);
        // tree.insert(2);
        // tree.insert(4);
        // tree.insert(6);
        // tree.insert(1);
        // tree.insert(8);
        // tree.insert(9);
        // tree.insert(10);
        // tree.inOrder(tree.root);
        // tree.preOrder(tree.root);
        // System.out.println(tree.min());
        createTree("5 3 7 2 4 6 1 9 8 10");
        tree.printDesc(tree.root);
        System.out.println();
        tree.bfs();

    }
}
