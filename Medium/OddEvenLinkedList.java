package Medium;

import tool.ListNode;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        ListNode oddHead = new ListNode();
        ListNode oddPtr = oddHead;
        ListNode evenHead = new ListNode();
        ListNode evenPtr = evenHead;
        boolean isOdd = true;
        ListNode tmp = head;
        while (tmp != null) {
            if (isOdd){
                oddPtr.next = tmp;
                tmp = tmp.next;
                oddPtr = oddPtr.next;
                oddPtr.next = null;
                isOdd = false;
            }else{
                evenPtr.next = tmp;
                tmp = tmp.next;
                evenPtr = evenPtr.next;
                evenPtr.next = null;
                isOdd = true;
            }
        }
        oddPtr.next = evenHead.next;
        return oddHead.next;
    }

    public static void main(String[] args) {
        OddEvenLinkedList lst = new OddEvenLinkedList();
        ListNode head = new ListNode(new int[]{2});
        System.out.println(lst.oddEvenList(null));
    }
}
