package Medium;

import java.util.*;

public class PalindromePartitioning {
    int n;
    boolean[][] dp;
    List<List<String>> res;
    Stack<String> tmpRes = new Stack<>();

    public List<List<String>> partition(String s) {
        n = s.length();
        dp = new boolean[n][n];
        res = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                if (j - i == 1)
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                else
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }

        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int index) {
        if (index >= n) {
            res.add(new ArrayList<>(tmpRes));
            return;
        }

        for (int i = index; i < n; i++) {
            if (dp[index][i]) {
                tmpRes.add(s.substring(index, i + 1));
                dfs(s, i + 1);
                tmpRes.pop();
            }
        }
    }

    public static void main(String[] args) {
        String s = "aabbab";
        System.out.println(new PalindromePartitioning().partition(s));
    }
}
