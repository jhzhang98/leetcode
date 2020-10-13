package Easy;

import tool.TreeNode;

import java.util.*;

public class MinimumAbsoluteDifferenceInBST {
    boolean haveFirstEle = false;
    int last = -1;
    int dis = Integer.MAX_VALUE;

    /***
     * 中序遍历，左->根->右，由小到大排列
     */
    private void search(TreeNode node) {
        if (node.left != null)
            search(node.left);
        if (haveFirstEle)
            dis = Math.min(dis, node.val - last);
        else
            haveFirstEle = true;
        last = node.val;
        if (node.right != null)
            search(node.right);
    }

    public int getMinimumDifference(TreeNode root) {
        search(root);
        return dis;
    }

    public static void main(String[] args) {
        MinimumAbsoluteDifferenceInBST bst = new MinimumAbsoluteDifferenceInBST();
        TreeNode node = new TreeNode(5, new TreeNode(3, null, new TreeNode(4)), new TreeNode(7, new TreeNode(6), new TreeNode(8)));
        System.out.println(bst.getMinimumDifference(node));
    }
}
