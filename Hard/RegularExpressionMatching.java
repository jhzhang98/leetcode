package Hard;

import java.util.*;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        Set<Integer> nextLegalState = new HashSet<>();
        nextState(p, 0, nextLegalState);
        int sIndex = 0;
        while (!nextLegalState.isEmpty()) {
            Set<Integer> curLegalState = nextLegalState;
            nextLegalState = new HashSet<>();
            for (int pIndex : curLegalState) {
                if (pIndex >= p.length() && sIndex >= s.length())
                    return true;
                else if (pIndex >= p.length())  // 由于可能添加超过p.length()的非法坐标，这里要判断一下
                    continue;
                if (sIndex >= s.length())
                    continue;       // 这里不能用break，因为可能存在某个pIndex也大于等于p.length，以至于返回true
                char c = p.charAt(pIndex);
                if (c == '.' || c == s.charAt(sIndex)) {
                    if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*')
                        nextState(p, pIndex, nextLegalState);   // 如果下一个是*，那么当前位置的next状态都合法，重复添加一遍
                    else
                        nextState(p, pIndex + 1, nextLegalState); // 如果下一个不是*，那么应该添加下一个位置的next合法位置
                }
            }
            sIndex++;
        }
        // 没有判断出终止状态，直接结束
        return false;
    }

    private void nextState(String p, int curState, Set<Integer> states) {
        states.add(curState); // 这里允许添加超过p.length()的位置，目的是可以直接通过state来判断p已经结束
        if (curState + 1 < p.length()) {
            if (p.charAt(curState + 1) == '*')
                nextState(p, curState + 2, states);
        }
    }

    public static void main(String[] args) {
        RegularExpressionMatching matching = new RegularExpressionMatching();
        System.out.println(matching.isMatch("abcdefccd", "ab.*ccd"));
//        System.out.println("ac".substring(0, 0));
    }
}
