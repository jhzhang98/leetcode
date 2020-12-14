package Medium;

import tool.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        int curLayerNum = 1;
        int nextLayerNum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> layerNum = new LinkedList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            layerNum.add(node.val);
            curLayerNum--;

            if (node.left != null) {
                queue.add(node.left);
                nextLayerNum++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLayerNum++;
            }
            if (curLayerNum == 0) {
                res.add(layerNum);
                layerNum = new LinkedList<>();
                curLayerNum = nextLayerNum;
                nextLayerNum = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal traversal = new BinaryTreeLevelOrderTraversal();
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<List<Integer>> res = traversal.levelOrder(root)    ;
        for (List<Integer> layer : res)
            System.out.println(layer);
    }
}
