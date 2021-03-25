package Offer;

import tool.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q55I {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int curLayer = 1, depth = 1;
        int nextLayer = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                nextLayer++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLayer++;
            }
            curLayer--;
            if (curLayer == 0) {
                curLayer = nextLayer;
                nextLayer = 0;
                depth++;
            }
        }
        return depth - 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(new Q55I().maxDepth(root));
    }
}
