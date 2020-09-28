package Medium;

import tool.Node;

public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null)
            return null;
        if (root.left != null && root.right != null)
            root.left.next = root.right;
        fill(root.right);
        fill(root.left);
        return root;
    }

    private void fill(Node root) {
        if (root == null)
            return;
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            if (root.next != null)
                root.right.next = root.next.left;
        }
        fill(root.right);
        fill(root.left);
    }
}
