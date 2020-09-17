package Medium;

import tool.ListNode;

public class SwapNodesInPairs {
    ListNode tail = null;

    private boolean reverseTwoNode() {
        ListNode a = tail.next;
        if (a == null)
            return false;
        ListNode b = a.next;
        if (b == null)
            return false;
        tail.next = null;
        a.next = b.next;
        b.next = a;
        tail.next = b;
        tail = a;
        return true;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = head.next;
        tail = new ListNode();
        tail.next = head;
        boolean continueFlag = true;
        while (continueFlag)
            continueFlag = reverseTwoNode();

        return newHead;
    }

    public static void main(String[] args) {
        SwapNodesInPairs snip = new SwapNodesInPairs();
//        ListNode l1 = new ListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(snip.swapPairs(null));
    }
}
