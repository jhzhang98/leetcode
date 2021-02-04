package Offer;

import java.util.Stack;

public class Q09 {
    class CQueue {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            stack1.add(value);
        }

        public int deleteHead() {
            if (stack1.isEmpty())
                return -1;
            while (!stack1.isEmpty())
                stack2.add(stack1.pop());
            int res = stack2.pop();
            while (!stack2.isEmpty())
                stack1.add(stack2.pop());
            return res;
        }
    }

}
