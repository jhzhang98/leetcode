package Offer;

import tool.ListNode;

public class Q52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = (p1.next == null) ? headB : p1.next;
            p2 = (p2.next == null) ? headA : p2.next;
        }
        return p1;
    }
}
