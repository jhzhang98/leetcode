package tool;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] vals) {
        if (vals.length == 0)
            return;
        this.val = vals[0];
        ListNode node = this;
        for (int i = 1; i < vals.length; i++) {
            node.next = new ListNode(vals[i]);
            node = node.next;
        }
    }

    @Override
    public String toString() {
        ListNode tmp = this;
        StringBuilder str = new StringBuilder();
        while (tmp != null) {
            str.append(tmp.val).append("->");
            tmp = tmp.next;
        }
        return str.substring(0, str.length() - 2);
    }
}
