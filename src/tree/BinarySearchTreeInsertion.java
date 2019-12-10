package tree;

public class BinarySearchTreeInsertion {

    static class Node {

        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);

        if (data < root.data) {
            if (root.left == null)
                root.left = new Node(data);
            else
                insert(root.left, data);
        } else {
            if (root.right == null)
                root.right = new Node(data);
            else
                insert(root.right, data);
        }
        return root;
    }

    public static void preorder(Node root) {
        System.out.print(root.data + " ");
        if (root.left != null)
            preorder(root.left);
        if (root.right != null)
            preorder(root.right);
    }

    public static void main(String[] args) {
        Node root = null;
        int[] data = {5, 3, 4, 6, 9, 10, 20, 16, 17, 12, 7, 7, 8};

        for (int datum : data)
            root = insert(root, datum);

        /*
         *   Tree visualization
         *     5
         *    / \
         *   3   6
         *    \   \
         *     4   9
         *        / \
         *       7   10
         *      / \    \
         *     7   8    20
         *             /
         *           16
         *          /  \
         *        12    17
         * */
        //print tree in preorder
        preorder(root);
    }
}
