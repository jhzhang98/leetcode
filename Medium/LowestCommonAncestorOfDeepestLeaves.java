package Medium;

import tool.BinaryTreeSearch;
import tool.TreeNode;

import java.util.*;

public class LowestCommonAncestorOfDeepestLeaves {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        int[] depth = getDepth(root, map);
        TreeNode res = new TreeNode(Integer.MIN_VALUE);
        dfs(root, depth[0], depth[1], map, res);
        return res.left;
    }

    private int[] getDepth(TreeNode root, Map<TreeNode, Integer> map) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curDepth = 0, curDepthNum = 0;
        int curLayerNum = 1, nextLayerNum = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            map.put(node, curDepth);
            curLayerNum--;
            curDepthNum++;

            if (node.left != null) {
                queue.add(node.left);
                nextLayerNum++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLayerNum++;
            }
            if (curLayerNum == 0) {
                curLayerNum = nextLayerNum;
                nextLayerNum = 0;
                if (!queue.isEmpty()) {
                    curDepth++;
                    curDepthNum = 0;
                }
            }
        }
        return new int[]{curDepth, curDepthNum};
    }

    private int dfs(TreeNode root, int maxDepth, int maxDepthNum, Map<TreeNode, Integer> map, TreeNode res) {
        if (res.left != null)
            return -1;

        int cnt;
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            cnt = (map.get(root) == maxDepth) ? 1 : 0;
        } else {
            int left = dfs(root.left, maxDepth, maxDepthNum, map, res);
            int right = dfs(root.right, maxDepth, maxDepthNum, map, res);
            int cur = (map.get(root) == maxDepth) ? 1 : 0;
            cnt = left + right + cur;
        }
        if (res.left == null && cnt == maxDepthNum)
            res.left = root;
        return cnt;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        root = new TreeNode(2);
        TreeNode res = new LowestCommonAncestorOfDeepestLeaves().lcaDeepestLeaves(root);
//        new BinaryTreeSearch().BFS(res);
        System.out.println(res);
    }
}
