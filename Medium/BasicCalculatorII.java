package Medium;

import java.util.Stack;

public class BasicCalculatorII {
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

    public int calculate(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push('$');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-' || (c >= '0' && c <= '9')) {
                stack.push(c);
            } else if (c == '*' || c == '/') {
                int num1 = popNum(stack);
                int[] num2Array = nextNum(s, i + 1);
                if (c == '*')
                    num1 *= num2Array[0];
                else
                    num1 /= num2Array[0];
                for (char t : ("" + num1).toCharArray())
                    stack.push(t);
                i += num2Array[1];
            }
        }

        int res = popNum(stack);
        while (stack.peek() != '$') {
            stack.pop();
            res += popNum(stack);
        }
        return res;
    }

    private int[] nextNum(String s, int i) {
        int res = 0;
        int start = i;
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                res += s.charAt(i++) - '0';
                res *= 10;
            } else if (s.charAt(i) == ' ') {
                i++;
            } else {
                break;
            }
        }
        return new int[]{res / 10, i - start};
    }

    public static void main(String[] args) {
        String s = "3+5 / 2";
        System.out.println(new BasicCalculatorII().calculate(s));
    }
}
