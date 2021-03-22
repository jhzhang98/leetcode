package Hard;

import java.util.*;

public class RemoveInvalidParentheses {
    Set<String> res = new HashSet<>();
    char[] charSet;

    private void dfs(int index, int leftDel, int rightDel, int leftCnt, boolean[] notChoose) {
        if (leftCnt < 0) return;
        if (index == charSet.length && leftDel == 0 && rightDel == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < charSet.length; i++) {
                if (notChoose[i]) continue;
                sb.append(charSet[i]);
            }
            res.add(sb.toString());
            return;
        } else if (index >= charSet.length) return;

        if (charSet[index] == '(') {
            // 可以不选这个左括号，那删除一个左括号，其他不变
            notChoose[index] = true;
            dfs(index + 1, leftDel - 1, rightDel, leftCnt, notChoose);
            notChoose[index] = false;
            // 可以保留这个左括号，那当前可匹配的左括号多一
            dfs(index + 1, leftDel, rightDel, leftCnt + 1, notChoose);
        } else if (charSet[index] == ')') {
            if (leftCnt == 0) {     // 当前没有左括号了，必须删除右括号
                if (rightDel == 0) return;
                notChoose[index] = true;
                dfs(index + 1, leftDel, rightDel - 1, leftCnt, notChoose);
                notChoose[index] = false;
            } else {     // 前面有做左括号进行匹配，可以删除右括号，也可以不删除
                if (rightDel != 0) { // 有右括号，可以选择删除右括号
                    notChoose[index] = true;
                    dfs(index + 1, leftDel, rightDel - 1, leftCnt, notChoose);
                    notChoose[index] = false;
                }
                dfs(index + 1, leftDel, rightDel, leftCnt - 1, notChoose);  // 不删除右括号，那匹配的左括号就要少一个
            }
        } else {
            dfs(index + 1, leftDel, rightDel, leftCnt, notChoose);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        charSet = s.toCharArray();
        int leftDel = 0, rightDel = 0;  // 左右括号各需要删除多少个
        int leftCnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') leftCnt++;
            else if (c == ')') leftCnt--;
            if (leftCnt < 0) {
                rightDel++;
                leftCnt = 0;
            }
        }
        leftDel += leftCnt;

        dfs(0, leftDel, rightDel, 0, new boolean[charSet.length]);
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        String s = "(a)())()";
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses(s));
    }
}
