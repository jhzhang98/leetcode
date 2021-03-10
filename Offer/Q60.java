package Offer;

import java.util.Arrays;

public class Q60 {
    /***
     dp[m][n] = sum{dp[m-1][n-j]} for 1<=j<=min(6, n);
     表示m次掷色子，掷出n的次数
     ***/
    public double[] dicesProbability(int n) {
        int[][] dp = new int[n + 1][n * 6 + 1];
        for (int i = 1; i <= 6; i++)
            dp[1][i] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= i * 6; j++) {
                int sum = 0;
                for (int k = 1; k <= Math.min(j - 1, 6); k++)
                    sum += dp[i - 1][j - k];
                dp[i][j] = sum;
            }
        }
        double[] res = new double[n * 5 + 1];
        for (int j = n; j <= n * 6; j++)
            res[j - n] = dp[n][j] * 1.0 / Math.pow(6, n);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q60().dicesProbability(4)));
    }
}
