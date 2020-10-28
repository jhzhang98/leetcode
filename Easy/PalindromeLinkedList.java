package Easy;

import tool.ListNode;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if (fast == null)
                break;
            slow = slow.next;
            fast = fast.next;
            if (fast == null)
                break;
            fast = fast.next;
        }

        ListNode tail = reverseLinkedList(slow);
        ListNode start = head;
        while (start != null && tail != null) {
            if (start.val != tail.val)
                return false;
            start = start.next;
            tail = tail.next;
        }
        return true;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode empty = new ListNode();
        ListNode tmp = head;
        while (tmp != null) {
            ListNode inputTail = tmp.next;
            ListNode resTail = empty.next;
            tmp.next = null;
            empty.next = tmp;
            empty.next.next = resTail;
            tmp = inputTail;
        }
        return empty.next;
    }

    public static void main(String[] args) {
        PalindromeLinkedList linkedList = new PalindromeLinkedList();
        ListNode node = new ListNode(new int[]{1, 2, 3, 3, 2 , 1});
        System.out.println(linkedList.isPalindrome(node));
    }
}
