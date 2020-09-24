package Easy;

import tool.TreeNode;

import java.util.*;

public class FindModeInBinarySearchTree {
    List<Integer> maxValue = new ArrayList<>();
    int maxCount = -1;
    int curVal;
    int count = -1;

    private void check(int val) {
        if (count == -1) {
            curVal = val;
            count = 1;
            return;
        }
        if (curVal != val) {
            if (maxCount == -1) {
                maxCount = count;
                maxValue.add(curVal);
            } else if (count > maxCount) {
                maxValue.clear();
                maxValue.add(curVal);
                maxCount = count;
            } else if (count == maxCount) {
                maxValue.add(curVal);
            }
            curVal = val;
            count = 1;
        } else {
            count++;
        }
    }

    private void search(TreeNode root) {
        if (root.left != null)
            search(root.left);
        check(root.val);
        if (root.right != null)
            search(root.right);
    }

    public int[] findMode(TreeNode root) {
        if (root == null)
            return maxValue.stream().mapToInt(Integer::valueOf).toArray();
        search(root);
        check(curVal + 1);
        return maxValue.stream().mapToInt(Integer::valueOf).toArray();
    }


    public static void main(String[] args) {
        FindModeInBinarySearchTree searchTree = new FindModeInBinarySearchTree();
//        TreeNode root = new TreeNode(5, new TreeNode(2, new TreeNode(2), new TreeNode(4)), new TreeNode(7, new TreeNode(6), new TreeNode(7)));
        TreeNode root = new TreeNode(5, new TreeNode(5, new TreeNode(5), null), null);
        int[] res = searchTree.findMode(root);
        System.out.println(Arrays.toString(res));
    }
}
