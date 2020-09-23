package Easy;

import tool.TreeNode;
import tool.BinaryTreeSearch;

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public static void main(String[] args) {
        MergeTwoBinaryTrees merge = new MergeTwoBinaryTrees();
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = null;
        TreeNode root = merge.mergeTrees(t1, t2);
        new BinaryTreeSearch().BFS(root);
    }
}
