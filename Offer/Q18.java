package Offer;

import tool.ListNode;

public class Q18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode tmp = dummy;

        while(tmp.next != null){
            if (tmp.next.val == val){
                tmp.next = tmp.next.next;
                break;
            }
            tmp = tmp.next;
        }

        return dummy.next;
    }
}
