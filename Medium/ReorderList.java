package Medium;

import tool.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReorderList {

    /***
     * 线性表，快了一丢丢
     */
    public void reorderList(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode tmp = head;
        while (!(tmp == null)) {
            nodes.add(tmp);
            tmp = tmp.next;
            nodes.get(nodes.size() - 1).next = null;
        }
        tmp = new ListNode();
        for (int i = 0; i <= nodes.size() / 2; i++) {
            if (i >= nodes.size() - 1 - i)
                break;
            tmp.next = nodes.get(i);
            tmp.next.next = nodes.get(nodes.size() - 1 - i);
            tmp = tmp.next.next;
        }
        if (nodes.size() % 2 == 1)
            tmp.next = nodes.get(nodes.size() / 2);
    }

    /***
     * 最暴力做法，用一个map存一下，直接按照index搞
     */
    public void reorderList2(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        int index = 0;
        ListNode p = head;
        while (p != null) {
            map.put(index, p);
            p = p.next;
            map.get(index++).next = null;
        }
        int nodeNum = map.keySet().size();
        p = new ListNode();
        for (int i = 0; i < (nodeNum + 1) / 2; i++) {
            if (nodeNum - i - 1 <= i)
                break;
            p.next = map.get(i);
            p = p.next;
            p.next = map.get(nodeNum - i - 1);
            p = p.next;
        }
        if (nodeNum % 2 == 1)
            p.next = map.get(nodeNum / 2);
    }

    public static void main(String[] args) {
        ReorderList list = new ReorderList();
        ListNode node = new ListNode(new int[]{1, 2, 3, 4});
        list.reorderList(node);
        System.out.println(node);
    }
}
