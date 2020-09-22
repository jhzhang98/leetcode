package Easy;

import sun.reflect.generics.tree.Tree;
import tool.TreeNode;

import java.util.*;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                if (node.left.left == null && node.left.right == null)
                    sum += node.left.val;
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        SumOfLeftLeaves sum = new SumOfLeftLeaves();
        TreeNode root = new TreeNode(0, new TreeNode(2, new TreeNode(1, new TreeNode(5), new TreeNode(1)), null), new TreeNode(4, new TreeNode(3, null , new TreeNode(6)), new TreeNode(-1, null, new TreeNode(8))));
        System.out.println(sum.sumOfLeftLeaves(root));
    }
}
