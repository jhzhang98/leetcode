package Medium;

import tool.TreeNode;

public class SmallestStringStartingFromLeaf {
    String min = "" + (char) ('z' + 1);
    StringBuilder curPath;

    public String smallestFromLeaf(TreeNode root) {
        curPath = new StringBuilder();
        dfs(root);
        return min;
    }

    private void dfs(TreeNode root) {
        curPath = curPath.insert(0, (char) ('a' + root.val));
        if (root.left == null && root.right == null) {
            if (curPath.toString().compareTo(min) < 0)
                min = curPath.toString();
            return;
        } else {
            if (root.left != null)
                dfs(root.left);
            if (root.right != null)
                dfs(root.right);
        }
        curPath = curPath.deleteCharAt(0);
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(25, new TreeNode(1, new TreeNode(1), new TreeNode(3)), new TreeNode(3, new TreeNode(0), new TreeNode(2)));
        TreeNode root = new TreeNode(0, null, new TreeNode(1));
        System.out.println(new SmallestStringStartingFromLeaf().smallestFromLeaf(root));
    }
}
