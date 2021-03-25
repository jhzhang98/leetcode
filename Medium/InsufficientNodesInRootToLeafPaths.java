package Medium;

import tool.BinaryTreeSearch;
import tool.TreeNode;

import java.util.*;

public class InsufficientNodesInRootToLeafPaths {
    Set<TreeNode> insufficient = new HashSet<>();

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        dfs(root, 0, limit);
        if (insufficient.contains(root)) return null;
        update(root);
        return root;
    }

    private void update(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (insufficient.contains(left))
            root.left = null;
        if (insufficient.contains(right))
            root.right = null;
        update(root.left);
        update(root.right);
    }

    private void dfs(TreeNode root, int curSum, int limit) {
        boolean leftSufficient = checkSufficient(root.left, limit - root.val);
        boolean rightSufficient = checkSufficient(root.right, limit - root.val);
        boolean sufficient = leftSufficient || rightSufficient;
        if (!sufficient)
            insufficient.add(root);
    }

    private boolean checkSufficient(TreeNode root, int limit) {
        if (root == null)
            return true;
        else if (root.right == null && root.left == null) {
            if (root.val < limit) insufficient.add(root);
            return root.val >= limit;
        } else {
            boolean leftSufficient = checkSufficient(root.left, limit - root.val);
            boolean rightSufficient = checkSufficient(root.right, limit - root.val);
            boolean sufficient = leftSufficient || rightSufficient;
            if (!sufficient) insufficient.add(root);
            return sufficient;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(1)), null), new TreeNode(8, new TreeNode(17), new TreeNode(4, new TreeNode(5), new TreeNode(3))));
        int limit = 22;
        new BinaryTreeSearch().BFS(new InsufficientNodesInRootToLeafPaths().sufficientSubset(root, limit));
    }

}
