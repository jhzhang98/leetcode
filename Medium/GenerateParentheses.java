package Medium;

import java.util.*;

public class GenerateParentheses {
    class State {
        String parenthesis;
        int left;
        int right;

        public State(String str, int left, int right) {
            this.parenthesis = str;
            this.left = left;
            this.right = right;
        }

        public String toString() {
            return parenthesis;
        }
    }

    public List<String> generateParenthesis(int n) {
        Stack<State> stack = new Stack<>();
        List<String> res = new ArrayList<>();
        stack.push(new State("(", 1, 0));

        while (!stack.isEmpty()) {
            State state = stack.pop();
            if (state.left == n && state.right == n)
                res.add(state.parenthesis);
            else if (state.left < n) {
                stack.push(new State(state.parenthesis + "(", state.left + 1, state.right));
                if (state.left > state.right)
                    stack.push(new State(state.parenthesis + ")", state.left, state.right + 1));
            } else if (state.right < n)
                stack.push(new State(state.parenthesis + ")", state.left, state.right + 1));
        }

        return res;
    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        int n = 0;
        System.out.println(gp.generateParenthesis(n));
    }
}
