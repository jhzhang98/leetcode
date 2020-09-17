package Medium;

import tool.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node1 = head;
        ListNode node2 = head;
        int dis = 0;
        if (n == 0)
            return head;
        // 保留距离
        while (dis++ < n)
            node2 = node2.next;

        if (node2 == null) // 去掉头
            return head.next;

        // 向后遍历
        while (node2.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }

        // 删除节点，调整顺序
        node1.next = node1.next.next;

        return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList rnel = new RemoveNthNodeFromEndOfList();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        System.out.println(rnel.removeNthFromEnd(root, 2));
    }
}
