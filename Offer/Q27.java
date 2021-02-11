package Offer;

import tool.TreeNode;

public class Q27 {
    public TreeNode mirrorTree(TreeNode root) {
        return reverse(root);
    }

    private TreeNode reverse(TreeNode root) {
        if (root == null)
            return null;
        else {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            reverse(root.left);
            reverse(root.right);
            return root;
        }
    }
}
