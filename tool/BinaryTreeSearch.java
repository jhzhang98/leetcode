package tool;

import java.util.*;

public class BinaryTreeSearch {

    public void DFS(Node root) {
        Stack<Node> stack = new Stack<>();
        if (root != null)
            stack.add(root);
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.append(node.val).append(", ");
            if (node.right != null)
                stack.add(node.right);
            if (node.left != null)
                stack.add(node.left);
        }
        System.out.println(result);
    }

    public void BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            result.append(node.val).append(", ");
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        System.out.println(result);
    }
}
