package Easy;

import tool.TreeNode;

public class DiameterOfBinaryTree {
    int maxPath = -1;

    private int maxDepth(TreeNode root) {
        if (root == null)
            return -1;
        else if (root.left == null && root.right == null)
            return 0;
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        maxPath = Math.max(maxPath, left + right);
        return Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return Math.max(left + right, maxPath);
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(5, new TreeNode(8), null), null), new TreeNode(6, new TreeNode(6, new TreeNode(7, new TreeNode(8), null), null), null)), null);
        System.out.println(tree.diameterOfBinaryTree(null));
    }
}
