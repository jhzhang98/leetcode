package Hard;

import tool.TreeNode;

import java.util.*;

public class BinaryTreeMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;

    private void dfs(TreeNode root, Map<TreeNode, Integer> scoreMap) {
        if (root == null) return;
        dfs(root.left, scoreMap);
        dfs(root.right, scoreMap);
        int leftVal = scoreMap.get(root.left);
        int rightVal = scoreMap.get(root.right);
        int localSum = root.val;
        if (leftVal > 0) localSum += leftVal;
        if (rightVal > 0) localSum += rightVal;
        maxSum = Math.max(localSum, maxSum);
        scoreMap.put(root, Math.max(Math.max(leftVal, rightVal) + root.val, root.val));
    }

    public int maxPathSum(TreeNode root) {
        Map<TreeNode, Integer> scoreMap = new HashMap<>();
        scoreMap.put(null, 0);
        dfs(root, scoreMap);
        return maxSum;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode root = new TreeNode(2, new TreeNode(-1), null);
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(root));
    }
}
