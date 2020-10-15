package Medium;

import tool.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    /***
     * 层序遍历，每次输出每层最后一个
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int layerNum = 1, nextLayerNum = 0, currentPop = 0;
        List<Integer> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            currentPop++;
            if (node.left != null) {
                queue.add(node.left);
                nextLayerNum++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLayerNum++;
            }
            if (currentPop == layerNum) {
                res.add(node.val);
                layerNum = nextLayerNum;
                nextLayerNum = 0;
                currentPop = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(10), null), null), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        BinaryTreeRightSideView view = new BinaryTreeRightSideView();
        System.out.println(view.rightSideView(null));
    }
}
