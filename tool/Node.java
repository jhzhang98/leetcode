package tool;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int x, Node left, Node right){
        val = x;
        this.left = left;
        this.right = right;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    @Override
    public String toString() {
        return "" + val;
    }

}
