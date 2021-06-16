package Medium;

import tool.BinaryTreeSearch;
import tool.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        TreeNode root = findRoot(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }

    private TreeNode findRoot(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) return null;
        if (pStart == pEnd) return new TreeNode(preorder[pStart]);
        TreeNode root = new TreeNode(preorder[pStart]);
        int iRootIndex = findIndex(inorder, iStart, root.val);
        if (iRootIndex > iStart)    // 说明有左子树
            root.left = findRoot(preorder, pStart + 1, pStart + (iRootIndex - iStart), inorder, iStart, iRootIndex - 1);
        if (iRootIndex < iEnd)  // 说明有右子树
            root.right = findRoot(preorder, pStart + (iRootIndex - iStart) + 1, pEnd, inorder, iRootIndex + 1, iEnd);
        return root;
    }

    private int findIndex(int[] order, int start, int val) {
        for (int i = start; i < order.length; i++) {
            if (order[i] == val) return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal traversal = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = traversal.buildTree(preorder, inorder);
        new BinaryTreeSearch().BFS(root);
    }
}
