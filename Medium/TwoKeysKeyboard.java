package Medium;

public class TwoKeysKeyboard {
    /***
     * dp[i,j] = 当前长度为i，paste中有j个
     * dp[i+1, j] = Min(dp[i+1-j, j]) + 1, for k < j   // 执行粘贴操作
     * dp[i, i] = Min(dp[i, i]) + 1, for k < j+1 // 执行复制操作
     */
    public int minSteps(int n) {
        return 0;
    }
}
