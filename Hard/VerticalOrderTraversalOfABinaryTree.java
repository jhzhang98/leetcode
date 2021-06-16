package Hard;

import tool.TreeNode;

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> infos = new ArrayList<>();
        search(root, new int[]{0, 0}, infos);
        infos.sort((o1, o2) -> {
            if (o1[0] < o2[0]) return -1;
            else if (o1[0] > o2[0]) return 1;
            else {
                if (o1[1] < o2[1]) return -1;
                else if (o1[1] > o2[1]) return 1;
                else return Integer.compare(o1[2], o2[2]);
            }
        });
        List<List<Integer>> res = new ArrayList<>();
        int curX = infos.get(0)[0];
        for (int i = 0; i < infos.size(); i++) {
            List<Integer> save = new ArrayList<>();
            for (; i < infos.size(); i++) {
                if (infos.get(i)[0] == curX)
                    save.add(infos.get(i)[2]);
                else {
                    curX = infos.get(i)[0];
                    i--;
                    break;
                }
            }
            res.add(save);
        }
        return res;
    }

    private void search(TreeNode root, int[] pos, List<int[]> infos) {
        if (root == null)
            return;
        infos.add(new int[]{pos[0], pos[1], root.val});
        search(root.left, new int[]{pos[0] - 1, pos[1] + 1}, infos);
        search(root.right, new int[]{pos[0] + 1, pos[1] + 1}, infos);
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(7)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        TreeNode root = new TreeNode(0, new TreeNode(1, new TreeNode(2), new TreeNode(3)), null);
        System.out.println(new VerticalOrderTraversalOfABinaryTree().verticalTraversal(root));
    }
}
