package Medium;

import tool.BinaryTreeSearch;
import tool.Node;
import tool.TreeNode;

public class PopulatingNextRightPointersInEachNodeII {
    public Node connect(Node root) {
        if (root == null)
            return root;
        root.next = null;
        if (root.right != null && root.left != null)
            root.left.next = root.right;
        fillChild(root.left);
        fillChild(root.right);
        return root;
    }

    private void fillChild(Node root) {
        if (root == null)
            return;
        // 1. 更新左节点Next
        if (root.right != null && root.left != null)     // 左右子节点都非空，左节点指向右节点
            root.left.next = root.right;
        else if (root.left != null) {                   // 右节点为空，左节点指向父节点next的子节点
            Node rootNext = root.next;
            if (rootNext != null) {
                while(rootNext.next != null)
                    rootNext = rootNext.next;
                if (rootNext.left != null)
                    root.left.next = rootNext.left;
                else if (rootNext.right != null)
                    root.left.next = rootNext.right;
            }
        }
        // 2. 更新右节点
        if (root.right != null) {
            Node rootNext = root.next;                   // 右节点非空，右节点指向父节点next的子节点
            if (rootNext != null) {
                while(rootNext.next != null)
                    rootNext = rootNext.next;
                if (rootNext.left != null)
                    root.right.next = rootNext.left;
                else if (rootNext.right != null)
                    root.right.next = rootNext.right;
            }
        }
        fillChild(root.right);
        fillChild(root.left);
    }

    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNodeII nodeII = new PopulatingNextRightPointersInEachNodeII();
        Node root = new Node(1, new Node(2, new Node(4, new Node(7), null), new Node(5)), new Node(3, null, new Node(6, null, new Node(8))));
        root = nodeII.connect(root);
        new BinaryTreeSearch().BFS(root);
    }
}