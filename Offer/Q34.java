package Offer;

import tool.TreeNode;

import java.util.*;

public class Q34 {
    List<List<Integer>> res = new ArrayList<>();

    private void dfs(List<Integer> curPath, int curSum, int target, TreeNode node) {
        if (node == null)
            return ;
        if (node.left == null && node.right == null) {
            if (curSum + node.val == target) {
                curPath.add(node.val);
                res.add(curPath);
            }
        } else {
            curPath.add(node.val);
            dfs(new ArrayList<>(curPath), curSum + node.val, target, node.left);
            dfs(new ArrayList<>(curPath), curSum + node.val, target, node.right);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(new ArrayList<>(), 0, target, root);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        System.out.println(new Q34().pathSum(root, 22));
        root = new TreeNode(-2, null, new TreeNode(-3));
        System.out.println(new Q34().pathSum(root, -5));
    }
}
