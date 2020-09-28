package Easy;

import tool.*;

import java.util.*;

public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> getParents = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        getParents.put(root, null);
        TreeNode pPointer = null, qPointer = null;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (pPointer == null && node.val == p.val)
                pPointer = node;
            else if (qPointer == null && node.val == q.val)
                qPointer = node;
            if (pPointer != null && qPointer != null)
                break;

            if (node.left != null) {
                queue.add(node.left);
                getParents.put(node.left, node);
            }
            if (node.right != null) {
                queue.add(node.right);
                getParents.put(node.right, node);
            }
        }

        Set<Integer> pParents = new HashSet<>();
        TreeNode tmp = pPointer;
        do {
            pParents.add(tmp.val);
            tmp = getParents.get(tmp);
        } while (tmp != null);
        tmp = qPointer;
        do {
            if (pParents.contains(tmp.val))
                return tmp;
            tmp = getParents.get(tmp);
        } while (tmp != null);

        return null;
    }


    public static void main(String[] args) {
        LowestCommonAncestorOfABinarySearchTree tree = new LowestCommonAncestorOfABinarySearchTree();
        TreeNode root = new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))), new TreeNode(8, new TreeNode(7), new TreeNode(9)));
        System.out.println(tree.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8)));
    }
}
