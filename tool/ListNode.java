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
        String str = "";
        while (tmp != null) {
            str += tmp.val + "->";
            tmp = tmp.next;
        }
        return str.substring(0, str.length() - 2);
    }
}
