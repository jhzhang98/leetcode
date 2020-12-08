package Medium;

import tool.ListNode;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;
        ListNode sortedLst = new ListNode();
        ListNode tmp = head;
        while (tmp != null) {
            ListNode node = tmp;
            tmp = tmp.next;
            node.next = null;
            insert(sortedLst, node);
        }
        return sortedLst.next;
    }

    private void insert(ListNode sortedLst, ListNode node) {
        ListNode tmp = sortedLst;
        while (true) {
            ListNode p = tmp.next;
            if (p == null) {
                tmp.next = node;
                break;
            } else if (p.val < node.val) {
                tmp = tmp.next;
            } else {
                tmp.next = node;
                node.next = p;
                break;
            }
        }
    }

    public static void main(String[] args) {
        InsertionSortList list = new InsertionSortList();
        ListNode head = new ListNode(1);
        System.out.println(list.insertionSortList(head));
    }
}
