package Medium;

import java.util.*;

import tool.TreeNode;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> searched = new HashSet<>();
        if (root != null)
            stack.push(root);
        List<Integer> res = new ArrayList<>();

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();

            if (node.left == null && node.right == null) {
                searched.add(node);
                res.add(stack.pop().val);
            } else if (node.left == null || searched.contains(node.left)) {
                node = stack.pop();
                searched.add(node);
                res.add(node.val);
                if (node.right != null)
                    stack.push(node.right);
            } else
                stack.push(node.left);
        }

        return res;
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal btit = new BinaryTreeInorderTraversal();
//        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
//        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
//        TreeNode root = new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));
        TreeNode root = new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null);
        System.out.println(btit.inorderTraversal(root));
    }
}
