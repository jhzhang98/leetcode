package Medium;

import tool.ListNode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> deleted = new HashSet<>();
        ListNode ptr = new ListNode();
        ListNode dummy = new ListNode();
        dummy.next = head;
        ptr = dummy;
        while (ptr.next != null) {
            if (!visited.contains(ptr.next.val)) {
                ptr = ptr.next;
                visited.add(ptr.val);
            } else {
                deleted.add(ptr.next.val);
                ptr.next = ptr.next.next;
            }
        }
        ptr = dummy;
        while (ptr.next != null) {
            if (!deleted.contains(ptr.next.val))
                ptr = ptr.next;
            else
                ptr.next = ptr.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(new int[]{1, 1, 2, 3, 4});
        System.out.println(new RemoveDuplicatesFromSortedListII().deleteDuplicates(node));
    }
}
