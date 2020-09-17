package Easy;

import tool.BinaryTreeSearch;
import tool.TreeNode;

import java.util.*;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null)
                continue;
            TreeNode tmpSave = node.left;
            node.left = node.right;
            node.right = tmpSave;
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTree ibt = new InvertBinaryTree();
//        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), null), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
        new BinaryTreeSearch().BFS(root);
        new BinaryTreeSearch().BFS(ibt.invertTree(root));
    }
}
