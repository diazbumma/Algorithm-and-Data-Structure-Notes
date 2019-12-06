package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraversal {

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

    public static void construct(int[] data, Node root) {
        for (int i = 0; i < data.length; i++) {
            add(root, data[i]);
        }
    }

    public static Node add(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node node;
            if (data <= root.data) {
                node = add(root.left, data);
                root.left = node;
            } else {
                node = add(root.right, data);
                root.right = node;
            }
            return root;
        }
    }

    public static void preorderTraversal(Node root) {
        System.out.print(root.data + " ");
        if (root.left != null)
            preorderTraversal(root.left);
        if (root.right != null)
            preorderTraversal(root.right);
    }

    public static void inorderTraversal(Node root) {
        if (root.left != null)
            inorderTraversal(root.left);
        System.out.print(root.data + " ");
        if (root.right != null)
            inorderTraversal(root.right);
    }

    public static void postorderTraversal(Node root) {
        if (root.left != null)
            postorderTraversal(root.left);
        if (root.right != null)
            postorderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrderTraversal(Node root) {
        int upperLevelSize;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            upperLevelSize = queue.size();
            for (int i = 0; i < upperLevelSize; i++) {
                Node node = queue.poll();
                System.out.print(node.data + " ");
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
    }

    public static int treeHeight(Node root) {
        if (root.left==null && root.right==null) {
            return 0;
        } else {
            int leftHeight = 0;
            int rightHeight = 0;
            if (root.left != null)
                leftHeight = treeHeight(root.left);
            if (root.right != null)
                rightHeight = treeHeight(root.right);
            if (leftHeight > rightHeight)
                return leftHeight+1;
            else
                return rightHeight+1;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        int[] data = {3, 4, 6, 9, 10, 20, 16, 17, 12, 7, 7, 8};
        construct(data, root);

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

        System.out.println("Preorder Traversal:");
        preorderTraversal(root);
        System.out.print("\n");

        System.out.println("Inorder Traversal:");
        inorderTraversal(root);
        System.out.print("\n");

        System.out.println("Postorder Traversal:");
        postorderTraversal(root);
        System.out.print("\n");

        System.out.println("Level Order Traversal:");
        levelOrderTraversal(root);
        System.out.print("\n");

        System.out.println("Tree height:");
        System.out.println(treeHeight(root));
    }
}
