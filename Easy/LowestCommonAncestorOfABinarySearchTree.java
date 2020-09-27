package Easy;

import tool.*;

import java.util.*;

public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        List<TreeNode> tree = new LinkedList<>();
        tree.add(root);
        int pIndex = -1, qIndex = -1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (pIndex == -1 && node.val == p.val)
                pIndex = tree.indexOf(node);
            else if (qIndex == -1 && node.val == q.val)
                qIndex = tree.indexOf(node);
            if (qIndex != -1 && pIndex != -1)
                break;
            tree.add(node.left);
            tree.add(node.right);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }

        Set<Integer> pParent = new HashSet<>();
        int i = 2 * pIndex + 1;
        do {
            i = (i - 1) / 2;
            pParent.add(tree.get(i).val);
        } while (i != 0);

        for (i = qIndex; i >= 0; i = (i - 1) / 2) {
            TreeNode qParent = tree.get(i);
            if (pParent.contains(qParent.val))
                return qParent;
            if (i == 0)
                break;
        }

        return null;
    }


    public static void main(String[] args) {
        LowestCommonAncestorOfABinarySearchTree tree = new LowestCommonAncestorOfABinarySearchTree();
        TreeNode root = new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))), new TreeNode(8, new TreeNode(7), new TreeNode(9)));
        System.out.println(tree.lowestCommonAncestor(root, new TreeNode(3), new TreeNode(2)));
    }
}
