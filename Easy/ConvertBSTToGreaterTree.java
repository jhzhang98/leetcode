package Easy;

import tool.TreeNode;

import java.util.*;

public class ConvertBSTToGreaterTree {
    private int sum;

    public TreeNode convertBST(TreeNode root){
        if (root.right != null)
            convertBST(root.right);
        sum += root.val;
        root.val = sum;
        if (root.left != null)
            convertBST(root.left);
        return root;
    }

    public TreeNode convertBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)
            return null;
        stack.add(root);
        Map<TreeNode, Integer> sumValue = new HashMap<>();
        int smallestVal = Integer.MIN_VALUE;
        int smallestSum = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (sumValue.containsKey(node.right) || (node.right == null)) {
                if (smallestVal == Integer.MIN_VALUE || smallestVal > node.val) {
                    if (smallestVal == Integer.MIN_VALUE) {
                        sumValue.put(node, node.val);
                        smallestVal = node.val;
                        smallestSum = smallestVal;
                    } else {
                        sumValue.put(node, node.val + smallestSum);
                        smallestSum = smallestSum + node.val;
                        smallestVal = node.val;
                    }
                }
            }
            if (node.left != null && !sumValue.containsKey(node.left))
                stack.push(node.left);
            if (!sumValue.containsKey(node))
                stack.push(node);
            if (node.right != null && !sumValue.containsKey(node.right))
                stack.push(node.right);
        }
        for (TreeNode node : sumValue.keySet())
            node.val = sumValue.get(node);

        return root;
    }

    public static void main(String[] args) {
        ConvertBSTToGreaterTree convert = new ConvertBSTToGreaterTree();
        TreeNode root = new TreeNode(4, new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))), new TreeNode(6, new TreeNode(5), new TreeNode(7, null, new TreeNode(8))));
//        TreeNode root = new TreeNode(0, new TreeNode(-1, new TreeNode(-3), null), new TreeNode(2, null, new TreeNode(4)));
        root = convert.convertBST(root);
        new tool.BinaryTreeSearch().BFS(root);
    }
}
