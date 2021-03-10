package Hard;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Character> stack = new Stack<>();
        s = "(" + s + ")";
        stack.push('#');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ')
                continue;
            if (c == ')') {
                int tmpRes = popNum(stack);
                if (stack.peek() != '(')
                    stack.pop();
                char opt = '#';
                while (stack.peek() != '(') {
                    int num1 = popNum(stack);
                    if (stack.peek() == '+' || stack.peek() == '-')
                        opt = stack.pop();
                    if (opt == '-')
                        tmpRes -= num1;
                    else {
                        tmpRes += num1;
                        opt = '+';
                    }
                }
                stack.pop();
                for (char t : ("" + tmpRes).toCharArray())
                    stack.push(t);
            } else {
                stack.push(c);
            }
        }
        return popNum(stack);
    }

    private int popNum(Stack<Character> stack) {
        int ans = 0;
        if (stack.peek() == '(')
            return ans;
        int tail = 1;
        while (stack.peek() >= '0' && stack.peek() <= '9') {
            ans += (stack.pop() - '0') * tail;
            tail *= 10;
        }
        if (stack.peek() == '-') {
            ans = -ans;
            stack.pop();
            if (stack.peek() == '-') {
                ans = -ans;
                stack.pop();
            }
            stack.push('+');
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "2-(5-6)";
        System.out.println(new BasicCalculator().calculate(s));
    }
}
