package Medium;

import tool.ListNode;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int cnt = 1;
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        dummy.next = head;
        while (cnt++ < left)
            dummy = dummy.next;
        cnt--;
        ListNode child = dummy.next;
        dummy.next = null;
        while (cnt++ <= right) {
            ListNode newHead = child;
            child = child.next;
            newHead.next = dummy.next;
            dummy.next = newHead;
        }

        ListNode tmp = dummy;
        while (tmp.next != null)
            tmp = tmp.next;
        tmp.next = child;

        return res.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1});
        System.out.println(new ReverseLinkedListII().reverseBetween(head, 1, 1));
    }
}
