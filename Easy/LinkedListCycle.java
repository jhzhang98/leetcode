package Easy;

import tool.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode rabbit = head;
        ListNode turtle = head;
        while (true) {
            if (rabbit.next != null)
                rabbit = rabbit.next;
            else
                return false;
            if (rabbit == turtle)
                return true;
            if (rabbit.next != null)
                rabbit = rabbit.next;
            else
                return false;
            if (rabbit == turtle)
                return true;
            turtle = turtle.next;
        }
    }
}
