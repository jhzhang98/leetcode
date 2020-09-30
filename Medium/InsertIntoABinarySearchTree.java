package Medium;

import tool.BinaryTreeSearch;
import tool.TreeNode;

public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (val > root.val) {
            if (root.right == null)
                root.right = new TreeNode(val);
            else insertIntoBST(root.right, val);
        } else {
            if (root.left == null)
                root.left = new TreeNode(val);
            else insertIntoBST(root.left, val);
        }
        return root;
    }

    public static void main(String[] args) {
        InsertIntoABinarySearchTree tree = new InsertIntoABinarySearchTree();
        TreeNode root = null;
        root = tree.insertIntoBST(root, 8);
        root = tree.insertIntoBST(root, 2);
        root = tree.insertIntoBST(root, 14);
        root = tree.insertIntoBST(root, 6);
        root = tree.insertIntoBST(root, 10);
        root = tree.insertIntoBST(root, 9);
        new BinaryTreeSearch().BFS(root);
    }
}
