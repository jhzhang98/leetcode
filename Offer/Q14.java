package Offer;

public class Q14 {
    public int cuttingRope(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 1;
            dp[i][1] = i;
        }
        int res = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                int localMax = 0;
                for (int k = 1; k < i; k++) {
                    localMax = Math.max(localMax, dp[i - k][j - 1] * k);
                }
                res = Math.max(localMax, res);
                dp[i][j] = localMax;
            }
        }

        return res;
    }
}
