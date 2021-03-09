package Offer;

import tool.Node;

public class Q36 {
    private Node search(Node root) {
        if (root == null)
            return null;
        root.left = search(root.left);
        root.right = search(root.right);
        return root;
    }

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        root.left = search(root.left);
        root.right = search(root.right);
        Node head = new Node();
        head.next = root;
        return head;
    }
}
