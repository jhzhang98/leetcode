package Easy;

import java.util.Stack;

public class MaximumNestingDepthOfTheParentheses {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int maxDepth = 0;
        for (char c : s.toCharArray()){
            if(c == '('){
                stack.add(c);
                maxDepth = Math.max(stack.size(), maxDepth);
            }else if(c == ')'){
                stack.pop();
            }
        }
        return maxDepth;
    }
}
