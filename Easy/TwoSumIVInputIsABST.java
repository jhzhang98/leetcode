package Easy;

import tool.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class TwoSumIVInputIsABST {
    int twoHalf = 0;

    private void search(TreeNode node, Set<Integer> set, int num) {
        if (node == null)
            return;
        search(node.left, set, num);
        search(node.right, set, num);
        set.add(node.val);
        if (num == node.val)
            twoHalf++;
    }

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        if (k % 2 != 0)
            search(root, set, -10086);
        else
            search(root, set, k / 2);
        if (twoHalf >= 2)
            return true;
        for (int num : set) {
            if (num == k / 2 && k == k / 2 * 2)
                continue;
            if (set.contains(k - num))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSumIVInputIsABST abst = new TwoSumIVInputIsABST();
        TreeNode root = new TreeNode(1);
        System.out.println(abst.findTarget(root, 2));
    }
}
