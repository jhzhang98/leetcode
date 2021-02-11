package Offer;

import tool.TreeNode;

public class Q26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        if (isSame(A, B))
            return true;
        else
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isSame(TreeNode a, TreeNode b) {
        if (b == null)
            return true;
        else if (a == null)
            return false;
        else if (a.val == b.val)
            return isSame(a.left, b.left) && isSame(a.right, b.right);
        else
            return false;
    }

}
