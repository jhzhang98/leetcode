package Medium;

import sun.reflect.generics.tree.Tree;
import tool.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root == null)
            return res;
        queue.add(root);
        int curLayNum = 1, nextLayNum = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (count < curLayNum) {
                if (count == 0)
                    res.add(new LinkedList<>());
                res.get(res.size() - 1).add(node.val);
                count++;
            } else {
                res.add(new LinkedList<>());
                res.get(res.size() - 1).add(node.val);
                curLayNum = nextLayNum;
                nextLayNum = 0;
                count = 1;
            }
            if (node.left != null) {
                queue.add(node.left);
                nextLayNum++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLayNum++;
            }
        }
        boolean reverse = false;
        for (List<Integer> layer : res) {
            if (reverse)
                Collections.reverse(layer);
            reverse = !reverse;
        }
        return res;
    }

    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal traversal = new BinaryTreeZigzagLevelOrderTraversal();
        TreeNode root = new TreeNode(3, new TreeNode(9, new TreeNode(7), new TreeNode(8, new TreeNode(6), null)), new TreeNode(20, new TreeNode(15), new TreeNode(7, new TreeNode(9), null)));
        for (List<Integer> layer : traversal.zigzagLevelOrder(root))
            System.out.println(layer);
    }

}
