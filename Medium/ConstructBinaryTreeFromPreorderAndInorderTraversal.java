package Medium;

import tool.BinaryTreeSearch;
import tool.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    int[] preorder, inorder;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < preorder.length; i++)
            map.put(preorder[i], i);

        TreeNode root = new TreeNode(preorder[0]);
        int rootIndex = 0;
        for (; rootIndex < inorder.length; rootIndex++) {
            if (inorder[rootIndex] == preorder[0])
                break;
        }
        root.left = findRoot(0, rootIndex);
        root.right = findRoot(rootIndex + 1, inorder.length);
        return root;
    }

    private TreeNode findRoot(int left, int right) {
        if (right <= left)
            return null;

        int rootIndex = -1, minRootInPreorder = Integer.MAX_VALUE;
        for (int i = left; i < right; i++) {
            if (map.get(inorder[i]) < minRootInPreorder) {
                minRootInPreorder = map.get(inorder[i]);
                rootIndex = i;
            }
        }
        if (rootIndex == -1)
            return null;
        TreeNode node = new TreeNode(inorder[rootIndex]);
        node.left = findRoot(left, rootIndex);
        node.right = findRoot(rootIndex + 1, right);
        return node;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal traversal = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {4, 3, 2, 1};
        TreeNode root = traversal.buildTree(preorder, inorder);
        new BinaryTreeSearch().BFS(root);
    }
}
