package Offer;

public class Q19 {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) return true;
        else if (s.length() == 0 || p.length() == 0) return false;

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) != '*') {
                    if (i > 0)
                        dp[i][j] = dp[i - 1][j - 1] && match(s.charAt(i - 1), p.charAt(j - 1));
                } else {
                    if (i >= 1 && !match(s.charAt(i - 1), p.charAt(j - 2))) {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        if (j >= 2)
                            dp[i][j] = dp[i][j - 2];
                        if (i >= 1)
                            dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    private boolean match(char c, char p) {
        return (p == '.') || (p == c);
    }

    public static void main(String[] args) {
        String s = "aaafeg";
        String p = "a*efeg";
        System.out.println(new Q19().isMatch(s, p));
    }
}
