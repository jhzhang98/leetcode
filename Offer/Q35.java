package Offer;

import tool.Node;

import java.util.HashMap;

public class Q35 {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node ptrSrc = head;
        Node newHead = new Node(head.val);
        Node ptrNew = newHead;
        HashMap<Node, Node> map = new HashMap<>();
        map.put(head, ptrNew);
        ptrSrc = ptrSrc.next;

        while (ptrSrc != null) {
            Node node = new Node(ptrSrc.val);
            map.put(ptrSrc, node);
            ptrNew.next = node;
            ptrNew = ptrNew.next;
            ptrSrc = ptrSrc.next;
        }

        ptrSrc = head;
        while(ptrSrc != null){
            map.get(ptrSrc).random = map.get(ptrSrc.random);
            ptrSrc = ptrSrc.next;
        }
        return newHead;
    }
}
