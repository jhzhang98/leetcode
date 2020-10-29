package Medium;

import tool.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        int sum = 0;

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();

            if (node.left != null) {
                node.left.val = node.val * 10 + node.left.val;
                nodes.add(node.left);
            }
            if (node.right != null) {
                node.right.val = node.val * 10 + node.right.val;
                nodes.add(node.right);
            }
            if (node.left == null && node.right == null)
                sum += node.val;
        }
        return sum;
    }
}
