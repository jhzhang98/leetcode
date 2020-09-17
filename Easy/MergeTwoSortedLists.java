package Easy;

import tool.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode pL1 = l1;
        ListNode pL2 = l2;
        ListNode tmp = head;
        while (pL1 != null || pL2 != null) {
            if (pL1 == null) {
                tmp.next = new ListNode(pL2.val);
                pL2 = pL2.next;
            } else if (pL2 == null) {
                tmp.next = new ListNode(pL1.val);
                pL1 = pL1.next;
            } else {
                if (pL1.val < pL2.val) {
                    tmp.next = new ListNode(pL1.val);
                    pL1 = pL1.next;
                } else {
                    tmp.next = new ListNode(pL2.val);
                    pL2 = pL2.next;
                }
            }
            tmp = tmp.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists mtsl = new MergeTwoSortedLists();
        ListNode l1 = null;
        ListNode l2 = null;
        System.out.println(mtsl.mergeTwoLists(l1, l2));
    }
}

