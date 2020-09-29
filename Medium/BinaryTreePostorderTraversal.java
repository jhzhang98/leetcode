package Medium;

import tool.TreeNode;

import java.util.*;

public class BinaryTreePostorderTraversal {
    List<Integer> res = new ArrayList<>();

    private void traversal(TreeNode root) {
        if (root == null)
            return;
        traversal(root.left);
        traversal(root.right);
        res.add(root.val);
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        traversal(root);
        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> searched = new HashSet<>();
        searched.add(null);
        if (root != null)
            stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (searched.contains(node.right) && searched.contains(node.left)) {
                stack.pop();
                res.add(node.val);
                searched.add(node);
                continue;
            }
            if (node.right != null)
                stack.add(node.right);
            if (node.left != null)
                stack.add(node.left);
        }
        return res;
    }

    public static void main(String[] args) {
        BinaryTreePostorderTraversal traversal = new BinaryTreePostorderTraversal();
        TreeNode root = new TreeNode(1);
        System.out.println(traversal.postorderTraversal(null));
    }
}
