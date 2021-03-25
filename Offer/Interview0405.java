package Offer;

import tool.TreeNode;

public class Interview0405 {
    private boolean isValidBST(TreeNode root, long smallestVal, long biggestVal) {
        if (root == null) return true;
        if (root.val < smallestVal || root.val > biggestVal) return false;
        return isValidBST(root.left, smallestVal, (long) root.val - 1) && isValidBST(root.right, (long) root.val + 1, biggestVal);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBST(root.left, Integer.MIN_VALUE, (long) root.val - 1)
                && isValidBST(root.right, (long) root.val + 1, Integer.MAX_VALUE);
    }
}
