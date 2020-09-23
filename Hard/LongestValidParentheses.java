package Hard;

import java.util.*;

public class LongestValidParentheses {
    Stack<Integer> parStack = new Stack<>();
    List<Integer> noPairIndex = new ArrayList<>();

    public int longestValidParentheses(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                parStack.add(i);
            else if (s.charAt(i) == ')') {
                if (parStack.size() > 0)
                    parStack.pop();
                else
                    noPairIndex.add(i);     // 统计匹配不上的右括号
            }
        }
        while (parStack.size() != 0)
            noPairIndex.add(parStack.pop());    // 统计匹配不上的左括号
        Collections.sort(noPairIndex);
        if (noPairIndex.size() == 0)
            return s.length();
        if (noPairIndex.size() == 1)
            return Math.max(noPairIndex.get(0), s.length() - noPairIndex.get(0) - 1);
        int len = noPairIndex.get(0) / 2 * 2;
        for (int i = 0; i + 1 < noPairIndex.size(); i++) {
            int localLen = noPairIndex.get(i + 1) - noPairIndex.get(i) - 1;
            if (localLen > len)
                len = localLen;
        }
        return Math.max(len, s.length() - 1 - noPairIndex.get(noPairIndex.size() - 1));
    }

    public static void main(String[] args) {
        LongestValidParentheses par = new LongestValidParentheses();
        String str = ")";
        System.out.println(par.longestValidParentheses(str));
    }
}
