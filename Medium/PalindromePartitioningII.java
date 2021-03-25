package Medium;

public class PalindromePartitioningII {
    public int minCut(String s) {
        int n = s.length();
        if (n == 1)
            return 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                if (j - i == 1)
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                else
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }

        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            if (dp[0][i]){
                cnt[i] = 0;
                continue;
            }
            int min = n;
            for (int j = 0; j < i; j++) {
                if (dp[j + 1][i])
                    min = Math.min(cnt[j] + 1, min);
            }
            cnt[i] = min;
        }
        return cnt[n - 1];
    }

    public static void main(String[] args) {
        String s = "aabaaba";
        System.out.println(new PalindromePartitioningII().minCut(s));
    }
}
