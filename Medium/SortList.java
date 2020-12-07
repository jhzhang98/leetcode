package Medium;

import tool.ListNode;

public class SortList {
    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null)
            return null;
        else if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast == tail)
                break;
            fast = fast.next;
        }

        ListNode part1 = sortList(head, slow);
        ListNode part2 = sortList(slow, tail);

        return merge(part1, part2);
    }

    private ListNode merge(ListNode part1, ListNode part2) {
        ListNode dummy = new ListNode();
        ListNode dummyPtr = dummy, part1Ptr = part1, part2Ptr = part2;

        while (true) {
            if (part2Ptr == null && part1Ptr == null)
                break;
            else if (part1Ptr == null) {
                dummyPtr.next = part2Ptr;
                part2Ptr = part2Ptr.next;
            } else if (part2Ptr == null) {
                dummyPtr.next = part1Ptr;
                part1Ptr = part1Ptr.next;
            } else {
                if (part1Ptr.val < part2Ptr.val) {
                    dummyPtr.next = part1Ptr;
                    part1Ptr = part1Ptr.next;
                } else {
                    dummyPtr.next = part2Ptr;
                    part2Ptr = part2Ptr.next;
                }
            }
            dummyPtr = dummyPtr.next;
        }

        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null)
            return null;
        else if (head.next == null)
            return head;
        return sortList(head, null);
    }

    public static void main(String[] args) {
        SortList list = new SortList();
        ListNode node =  new ListNode(new int[]{3,4,5,2,54,2,4,2,25,6,7});
        System.out.println(list.sortList(node));
    }
}
