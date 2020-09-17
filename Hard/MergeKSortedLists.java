package Hard;

import tool.ListNode;

import javax.jnlp.IntegrationService;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {

    /**
     * 判断当前还有node剩余
     */
    private boolean nodeRemained(ListNode[] lists) {
        for (ListNode node : lists)
            if (null != node)
                return true;
        return false;
    }

    /**
     * 尝试用优先队列来做，看看速度变化
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode[] pList = new ListNode[lists.length];
        System.arraycopy(lists, 0, pList, 0, lists.length);
        ListNode head = new ListNode();
        ListNode tmp = head;
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : pList) {
            while (node != null) {
                queue.add(node);
                ListNode tmpNode = node;
                node = node.next;
                tmpNode.next = null;
            }
        }

        while (!queue.isEmpty()) {
            tmp.next = queue.poll();
            tmp = tmp.next;
        }

        return head.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode[] pList = new ListNode[lists.length];
        System.arraycopy(lists, 0, pList, 0, lists.length);
        ListNode head = new ListNode();
        ListNode tmp = head;

        while (nodeRemained(pList)) {
            int minIndex = -1;
            int minValue = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (pList[i] == null)
                    continue;
                if (pList[i].val < minValue) {
                    minIndex = i;
                    minValue = pList[i].val;
                }
            }
            tmp.next = new ListNode(minValue);
            tmp = tmp.next;
            pList[minIndex] = pList[minIndex].next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists mksl = new MergeKSortedLists();
        ListNode l1 = new ListNode(-2, new ListNode(-1, new ListNode(-1, new ListNode(-1))));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));
        System.out.println(mksl.mergeKLists2(new ListNode[]{l1, l2, l3}));
    }
}
