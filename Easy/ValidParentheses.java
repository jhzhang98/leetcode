package Easy;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> check = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')
                check.push(c);
            else {
                if (check.size() == 0)
                    return false;
                char leftP = check.pop();
                if ((leftP == '(' && c == ')') || (leftP == '[' && c == ']') || (leftP == '{' && c == '}'))
                    continue;
                return false;
            }
        }
        return check.size() == 0;
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        String s = "[(])";
        System.out.println(vp.isValid(s));
    }
}
