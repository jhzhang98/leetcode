package Easy;

import tool.TreeNode;

import java.util.*;

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        Queue<TreeNode> state = new LinkedList<>();
        Map<TreeNode, Integer> layerNum = new HashMap<>(); // 记录节点对应层数
        Map<Integer, Integer> layerCount = new HashMap<>(); // 记录该层数有几个节点
        layerNum.put(root, 0);
        List<Double> res = new ArrayList<>();
        Set<TreeNode> searched = new HashSet<>();
        state.add(root);

        while (!state.isEmpty()) {
            TreeNode node = state.poll();
            searched.add(node);

            int layer = layerNum.get(node);
            if (res.size() - 1 < layer) {
                res.add(node.val * 1.0);
                layerCount.put(layer, 1);
            }
            else {
                res.set(layer, res.get(layer) + node.val);
                layerCount.put(layer, layerCount.get(layer) + 1);
            }

            if (node.left != null && !searched.contains(node.left)) {
                layerNum.put(node.left, layer + 1);
                state.add(node.left);
            }
            if (node.right != null && !searched.contains(node.right)) {
                layerNum.put(node.right, layer + 1);
                state.add(node.right);
            }
        }
        for (int layer = 0; layer < res.size(); layer++) {
            res.set(layer, res.get(layer) / layerCount.get(layer));
        }
        return res;
    }

    public static void main(String[] args) {
        AverageOfLevelsInBinaryTree atree = new AverageOfLevelsInBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left= new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
        System.out.println(atree.averageOfLevels(root));
    }
}
