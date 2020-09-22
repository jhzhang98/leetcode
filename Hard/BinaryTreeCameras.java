package Hard;

import tool.TreeNode;

import java.util.*;

public class BinaryTreeCameras {

    private int cameraNum;

    public int minCameraCover(TreeNode root) {
        if (search(root) == 0)
            cameraNum++;
        return cameraNum;
    }

    /***
     *  从根节点递归向上，叶节点不需要camera，贪心
     * @return 0: 需要camera
     *          1: 被camera覆盖
     *          2: camera节点
     */
    int search(TreeNode node) {
        if (node == null)
            return 1;       // 为空的有可能被探测到，如右子树为空，根据多种情况分析得到返回1，否则需要在后面针对左右子树是否为空分很多类
        if (node.left == null && node.right == null) {   // 叶节点
            return 0;
        }
        int left = search(node.left);
        int right = search(node.right);
        if (left == 0 || right == 0) {  // 任意一边需要camera，均需要放一个camera
            cameraNum++;
            return 2;
        }

        if (left == 1 && right == 1)    // 两子节点都被覆盖，则该节点需要camera
            return 0;

        if (left + right > 2)           // 两子节点中任意一者有camera，不需要camera
            return 1;
        return -1;
    }

    public static void main(String[] args) {
        BinaryTreeCameras cameras = new BinaryTreeCameras();
        TreeNode root = new TreeNode(0, new TreeNode(0, new TreeNode(0), null), null);
        System.out.println(cameras.minCameraCover(root));
    }
}
