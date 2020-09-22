package tool;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSearch {
    public void BFS(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder result = new StringBuilder();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            result.append("" + node.val + ", ");
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        System.out.println(result);
    }
}
