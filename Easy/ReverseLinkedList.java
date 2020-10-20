package Easy;

import tool.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode empty = new ListNode();
        ListNode p = head;
        while(p != null) {
            if (empty.next == null) {
                empty.next = new ListNode(p.val);
                p = p.next;
            }
            else {
                ListNode save = empty.next;
                empty.next = new ListNode(p.val);
                p = p.next;
                empty.next.next = save;
            }
        }
        return empty.next;
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        list.reverseList(head);
        System.out.println(head);
    }
}
