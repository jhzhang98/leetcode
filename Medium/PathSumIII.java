package Medium;

import tool.TreeNode;

import java.util.*;

public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        Map<TreeNode, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!map.containsKey(node)) {
                map.put(node, new LinkedList<>());
                map.get(node).add(node.val);
                if (node.val == sum)
                    count++;
            } else {
                for (int val : map.get(node))
                    if (val == sum)
                        count++;
            }

            if (node.left != null) {
                map.put(node.left, new LinkedList<>());
                List<Integer> lst = map.get(node.left);
                lst.add(node.left.val);
                for (int val : map.get(node))
                    lst.add(val + node.left.val);
                queue.add(node.left);
            }
            if (node.right != null) {
                map.put(node.right, new LinkedList<>());
                List<Integer> lst = map.get(node.right);
                lst.add(node.right.val);
                for (int val : map.get(node))
                    lst.add(val + node.right.val);
                queue.add(node.right);
            }
            map.remove(node);
        }

        return count;
    }

    public static void main(String[] args) {
        PathSumIII pathSumIII = new PathSumIII();
        TreeNode node = new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))), new TreeNode(-3, null, new TreeNode(11)));
        System.out.println(pathSumIII.pathSum(node, 8));
    }
}
