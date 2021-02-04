package Offer;

import tool.ListNode;

public class Q06 {
    public int[] reversePrint(ListNode head) {
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        int[] res = new int[len];
        tmp = head;
        for (int i = len - 1; i >= 0; i--) {
            res[i] = tmp.val;
            tmp = tmp.next;
        }
        return res;
    }
}
