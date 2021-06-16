package Hard;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j <= p.length(); j++)
            dp[0][j] = dp[0][j - 1] && p.charAt(j - 1) == '*';

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) != '*')
                    dp[i][j] = dp[i - 1][j - 1] && match(s.charAt(i - 1), p.charAt(j - 1));
                else
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
            }
        }
        return dp[s.length()][p.length()];
    }

    private boolean match(char s, char p) {
        if (p == '?') return true;
        return s == p;
    }

    public static void main(String[] args) {
        String s = "a";
        String p = "***a**";
        System.out.println(new WildcardMatching().isMatch(s, p));
    }
}
