package Medium;

import tool.ListNode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode();
        ListNode small = new ListNode();
        ListNode big = new ListNode();
        ListNode ptrSmall = small, ptrBig = big;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val < x) {
                ptrSmall.next = cur;
                ptrSmall = ptrSmall.next;
            }else{
                ptrBig.next = cur;
                ptrBig = ptrBig.next;
            }
            cur.next = null;
            cur = next;
        }
        if (small.next != null)
            dummy.next = small.next;
        else
            dummy.next = big.next;
        ptrSmall.next = big.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 4, 3, 2, 5, 2});
        System.out.println(new PartitionList().partition(head, 1));
    }
}
