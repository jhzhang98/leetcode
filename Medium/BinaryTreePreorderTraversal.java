package Medium;

import tool.TreeNode;

import java.util.*;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        bfs(root, res);
        return res;
    }

    private void bfs(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        res.add(root.val);
        bfs(root.left, res);
        bfs(root.right, res);
    }

    public static void main(String[] args) {
        BinaryTreePreorderTraversal traversal = new BinaryTreePreorderTraversal();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        System.out.println(traversal.preorderTraversal(root));
    }
}
