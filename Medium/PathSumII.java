package Medium;


import tool.*;

import java.util.*;
import java.util.stream.*;

public class PathSumII {

    List<List<Integer>> resII = new ArrayList<>();

    private void search(TreeNode root, int curSum, List<Integer> path) {
        path.add(root.val);
        if (root.left == null && root.right == null && curSum == root.val)
            resII.add(new ArrayList<>(path));
        if (root.left != null)
            search(root.left, curSum - root.val, path);
        if (root.right != null)
            search(root.right, curSum - root.val, path);
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> pathSumII(TreeNode root, int sum) {
        if (root == null)
            return resII;
        search(root, sum, new ArrayList<>());
        return resII;
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        Map<TreeNode, Integer> curSum = new HashMap<>();
        Map<TreeNode, TreeNode> getParent = new HashMap<>();
        if (root != null) {
            stack.add(root);
            getParent.put(root, null);
            curSum.put(root, root.val);
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int curPathSum = curSum.get(node);
            if (node.left == null && node.right == null && curPathSum == sum) {
                TreeNode tmp = node;
                List<Integer> pathReverse = new ArrayList<>();
                do {
                    pathReverse.add(tmp.val);
                    tmp = getParent.get(tmp);
                } while (tmp != null);
                List<Integer> path = new ArrayList<>();
                for (int i = pathReverse.size() - 1; i >= 0; i--)
                    path.add(pathReverse.get(i));
                res.add(path);
            }

            if (node.right != null) {
                stack.add(node.right);
                curSum.put(node.right, node.right.val + curPathSum);
                getParent.put(node.right, node);
            }
            if (node.left != null) {
                stack.add(node.left);
                curSum.put(node.left, node.left.val + curPathSum);
                getParent.put(node.left, node);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        PathSumII sumII = new PathSumII();
        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        List<List<Integer>> res = sumII.pathSumII(root, 22);
        for (List<Integer> path : res)
            System.out.println(path);
    }
}
