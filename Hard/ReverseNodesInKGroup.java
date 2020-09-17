package Hard;

import tool.ListNode;

public class ReverseNodesInKGroup {
    private ListNode newHead;           // 一个一个reverse的时候的当前头
    private ListNode nextReverseNode;   // 接下来要reverse的节点

    private ListNode KNodesHead;
    private ListNode KNodesTail;

    private ListNode reverseKNodesHead;

    private void reverseOneNode() {
        ListNode newNext = nextReverseNode.next;
        nextReverseNode.next = newHead;
        newHead = nextReverseNode;
        nextReverseNode = newNext;
    }

    private boolean reverseKNodes(int k) {    // 从head开始，以k个为一组，reverse，返回新的头和尾巴
        if (reverseKNodesHead == null)
            return false;
        KNodesTail = reverseKNodesHead;
        // 1. 检查长度是否够k
        ListNode tmp = reverseKNodesHead;
        int count = k;
        while (--count > 0 && tmp != null)
            tmp = tmp.next;
        if (count > 0 || tmp == null)
            return false;
        tmp = tmp.next;  //存住下一个要转换的k group的head

        // 2. 逐个把下一个node放到前面
        newHead = reverseKNodesHead;
        nextReverseNode = newHead.next;
        newHead.next = null; // 不设置为null会循环引用
        count = k;
        while(--count > 0)
            reverseOneNode();
        KNodesHead = newHead;

        reverseKNodesHead = tmp;
        return true;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = null;
        ListNode kGroupTail = null;
        reverseKNodesHead = head;
        while (reverseKNodes(k)) {
            if (newHead == null)
                newHead = KNodesHead;
            if (kGroupTail != null) {
                kGroupTail.next = KNodesHead;
            }
            kGroupTail = KNodesTail;
        }
        if (null == newHead)
            return head;
        if (KNodesHead != null && kGroupTail != KNodesTail &&  kGroupTail != null)
            kGroupTail.next = KNodesTail;
        return newHead;
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup reverse = new ReverseNodesInKGroup();
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8,9});
        System.out.println(reverse.reverseKGroup(head, 0));
    }
}
