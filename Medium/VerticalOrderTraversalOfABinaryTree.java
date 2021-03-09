package Medium;

import tool.TreeNode;

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<TreeNode, Integer> vertical = new HashMap<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        vertical.put(root, 0);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            int pos = vertical.get(node);
            if (map.containsKey(pos)) {
                map.get(pos).add(node.val);
            } else {
                List<Integer> s = new LinkedList<>();
                s.add(node.val);
                map.put(pos, s);
            }
            if (node.left != null) {
                nodes.add(node.left);
                vertical.put(node.left, pos - 1);
            }
            if (node.right != null) {
                nodes.add(node.right);
                vertical.put(node.right, pos + 1);
            }
        }

        List<Integer> keyLst = new ArrayList<>(map.keySet());
        List<List<Integer>> res = new ArrayList<>();
        keyLst.sort(Integer::compare);
        for (int key : keyLst)
            res.add(map.get(key));
        return res;
    }
}
