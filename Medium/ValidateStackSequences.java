package Medium;

import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (popped.length != pushed.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        int length = popped.length;
        int pushIndex = 0, popIndex = 0;
        while (pushIndex != length || popIndex != length) {
            if (popIndex < length && !stack.isEmpty() && stack.peek() == popped[popIndex]) { // 弹栈操作
                System.out.println("pop: " + stack.pop());
                popIndex++;
            } else if (pushIndex < length && popIndex < length && pushed[pushIndex] == popped[popIndex]) {    // 压栈+弹栈操作
                System.out.println("push: " + pushed[pushIndex]);
                System.out.println("pop: " + popped[popIndex]);
                pushIndex++;
                popIndex++;
            } else if (pushIndex < length && popIndex < length && pushed[pushIndex] != popped[popIndex]) {      // 压栈操作
                System.out.println("push: " + pushed[pushIndex]);
                stack.add(pushed[pushIndex]);
                pushIndex++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidateStackSequences stackSequences = new ValidateStackSequences();
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        System.out.println(stackSequences.validateStackSequences(pushed, popped));
    }
}
