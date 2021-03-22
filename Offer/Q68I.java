package Offer;

import tool.TreeNode;

import java.util.*;

public class Q68I {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);
        if (root.val > max) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < min) {
            return lowestCommonAncestor(root.right, p, q);
        } else
            return root;
    }
}
