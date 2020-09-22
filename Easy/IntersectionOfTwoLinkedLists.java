package Easy;

import tool.ListNode;
import java.util.*;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> lstA = new Stack<>();
        Stack<ListNode> lstB = new Stack<>();
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        while(tmpA != null) {
            lstA.add(tmpA);
            tmpA = tmpA.next;
        }while(tmpB != null){
            lstB.add(tmpB);
            tmpB = tmpB.next;
        }
        ListNode equalsNode = null;
        while(!lstA.isEmpty() && !lstB.isEmpty()){
            if (lstA.peek() == lstB.peek())
                break;
            else {
                equalsNode = lstA.peek();
                lstA.pop();
                lstB.pop();
            }
        }
        return equalsNode;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists inter = new IntersectionOfTwoLinkedLists();
        ListNode headA = new ListNode(new int[]{4, 1, 8, 4, 5});
        ListNode headB = new ListNode(new int[]{5, 0, 1, 8, 4, 5});
        System.out.println(inter.getIntersectionNode(headA, headB).val);
    }
}
