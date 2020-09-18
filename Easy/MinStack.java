package Easy;

import java.util.*;

public class MinStack {
    List<Integer> valStack;
    List<Integer> minStack;
    int curMin = Integer.MAX_VALUE;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        valStack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        valStack.add(x);
        if (minStack.size() == 0 || curMin > x) {
            minStack.add(x);
            curMin = x;
        } else
            minStack.add(curMin);
    }

    public void pop() {
        valStack.remove(valStack.size() - 1);
        minStack.remove(minStack.size() - 1);
        curMin = minStack.get(minStack.size() - 1);
    }

    public int top() {
        return valStack.get(valStack.size() - 1);
    }

    public int min() {
        return minStack.get(minStack.size() - 1);
    }

    public String toString() {
        return valStack.toString() + "\n" + minStack.toString();
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(-10);
        ms.push(14);
        ms.push(-20);
        ms.pop();
        ms.push(10);
        ms.push(-7);
        ms.push(-7);
        ms.pop();
        ms.pop();
    }

}
