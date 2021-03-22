package Hard;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length())
            return 0;
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= t.length() && j <= i; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "def";
        System.out.println(new DistinctSubsequences().numDistinct(s, t));
    }
}
