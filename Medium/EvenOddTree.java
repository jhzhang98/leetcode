package Medium;

import tool.TreeNode;

import java.util.*;

public class EvenOddTree {
    boolean check(int currentLayer, List<Integer> layerNum) {
        if (currentLayer % 2 == 0) {    // 奇数，并且严格递增
            int last = layerNum.get(0);
            if (last % 2 == 0)
                return false;
            for (int i = 1; i < layerNum.size(); i++) {
                if (layerNum.get(i) % 2 == 0 || layerNum.get(i) <= last)
                    return false;
                last = layerNum.get(i);
            }
        } else {        // 偶数，并且严格递减
            int last = layerNum.get(0);
            if (last % 2 == 1)
                return false;
            for (int i = 1; i < layerNum.size(); i++) {
                if (layerNum.get(i) % 2 == 1 || layerNum.get(i) >= last)
                    return false;
                last = layerNum.get(i);
            }
        }
        return true;
    }

    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> layers = new LinkedList<>();
        nodes.add(root);
        layers.add(0);

        List<Integer> layerNum = new ArrayList<>();
        int currentLayer = 0;
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            int layer = layers.poll();

            if (layer == currentLayer)
                layerNum.add(node.val);
            else {
                if (!check(currentLayer, layerNum))
                    return false;
                currentLayer = layer;
                layerNum.clear();
                layerNum.add(node.val);
            }

            if (node.left != null) {
                nodes.add(node.left);
                layers.add(layer + 1);
            }
            if (node.right != null) {
                nodes.add(node.right);
                layers.add(layer + 1);
            }
        }
        if (!layerNum.isEmpty())
            return check(currentLayer, layerNum);

        return true;
    }

    public static void main(String[] args) {
        EvenOddTree tree = new EvenOddTree();
        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(3), new TreeNode(3)), new TreeNode(2, new TreeNode(7), null));
        System.out.println(tree.isEvenOddTree(root));
    }
}
