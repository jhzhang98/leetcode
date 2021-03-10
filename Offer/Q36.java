package Offer;

import tool.Node;

import java.util.LinkedList;
import java.util.List;

public class Q36 {
    List<Node> nodes = new LinkedList<>();

    private void search(Node root) {
        if (root == null)
            return;
        search(root.left);
        nodes.add(root);
        search(root.right);
        root.left = null;
        root.right = null;
    }

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        Node dummy = new Node();
        Node ptr = dummy;
        search(root);
        for (int i = 0; i < nodes.size(); i++) {
            ptr.right = nodes.get(i);
            nodes.get(i).left = ptr;
            ptr = ptr.right;
        }
        ptr.right = dummy.right;
        dummy.left = ptr;
        return dummy;
    }

}
