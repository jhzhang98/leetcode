package Easy;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> pushStack;
    Stack<Integer> popStack;
    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>() ;
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        this.pushStack.add(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        while(!pushStack.isEmpty())
            popStack.add(pushStack.pop());
        int x = popStack.pop();
        while(!popStack.isEmpty())
            pushStack.add(popStack.pop());
        return x;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        while(!pushStack.isEmpty())
            popStack.add(pushStack.pop());
        int x = popStack.peek();
        while(!popStack.isEmpty())
            pushStack.add(popStack.pop());
        return x;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return pushStack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}
