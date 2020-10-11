package Medium;

import tool.ListNode;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode rabbit = head;
        ListNode turtle = head;
        while (true) {
            if (rabbit.next != null)
                rabbit = rabbit.next;
            else
                return null;
            if (rabbit == turtle)
                return rabbit;
            if (rabbit.next != null)
                rabbit = rabbit.next;
            else
                return null;
            if (rabbit == turtle)
                return rabbit;
            turtle = turtle.next;
        }
    }
}
