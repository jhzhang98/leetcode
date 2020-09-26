package Medium;

import tool.BinaryTreeSearch;
import tool.TreeNode;

import java.util.*;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    int[] rootPos;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        rootPos = new int[postorder.length];
        Map<Integer, Integer> numToPos = new HashMap<>();
        for (int i = 0; i < postorder.length; i++)
            numToPos.put(postorder[i], i);
        for (int i = 0; i < inorder.length; i++)
            rootPos[i] = numToPos.get(inorder[i]);

        TreeNode root = buildSubTree(inorder, 0, inorder.length - 1);

        return root;
    }

    private int findRoot(int start, int end) {
        int rootIndex = -1;
        int maxValue = -1;
        for (int i = start; i <= end; i++) {
            if (rootPos[i] > maxValue) {
                maxValue = rootPos[i];
                rootIndex = i;
            }
        }
        return rootIndex;
    }

    private TreeNode buildSubTree(int[] inorder, int start, int end) {
        if (start > end)    //  超了，说明没有了
            return null;
        if (start == end)   //  只有一个数，返回之
            return new TreeNode(inorder[start]);
        int rootIndex = findRoot(start, end);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        root.left = buildSubTree(inorder, start, rootIndex - 1);
        root.right = buildSubTree(inorder, rootIndex + 1, end);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversal construct = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
//        int[] inorder = {9, 3, 15, 20, 7}, postorder = {9, 15, 7, 20, 3};
//        int[] postorder = {7, 6, 2, 5, 4, 3, 1}, inorder = {2, 7, 6, 1, 3, 5, 4};
        int[] postorder = {7}, inorder = {7};
        TreeNode root = construct.buildTree(inorder, postorder);
        new BinaryTreeSearch().BFS(root);

    }
}
