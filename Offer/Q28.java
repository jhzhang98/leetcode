package Offer;

import tool.TreeNode;

public class Q28 {
    private boolean checkMirror(TreeNode A, TreeNode B){
        if (A == null && B == null)
            return true;
        else if (A == null || B == null)
            return false;
        else if (A.val != B.val)
            return false;
        else
            return checkMirror(A.left, B.right) && checkMirror(A.right, B.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return checkMirror(root.left, root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)));
        System.out.println(new Q28().isSymmetric(root));
    }
}
