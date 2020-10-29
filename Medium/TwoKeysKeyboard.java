package Medium;

import java.util.Arrays;

public class TwoKeysKeyboard {
    /***
     * dp[i,j] = 当前长度为i，paste中有j个
     * dp[i+j, j] = Min(dp[i, j]) + 1, dp[i+j, j]) // 粘贴操作
     * dp[i, i] = Min(dp[i, i], dp[i, j] + 1) // 执行复制操作
     */
    public int minSteps(int n) {
        int[][] dp = new int[n + 1][n + 1];
        int initValue = Integer.MAX_VALUE >> 2;
        for (int i = 0; i <= n; i++)
            Arrays.fill(dp[i], initValue);
        dp[1][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) { // 粘贴板中内容不可能超过当前内容长度
                if (i + j <= n)
                    dp[i + j][j] = Math.min(dp[i + j][j], dp[i][j] + 1);
                dp[i][i] = Math.min(dp[i][i], dp[i][j] + 1);
            }
        }

        return Arrays.stream(dp[n]).min().getAsInt();
    }
}
