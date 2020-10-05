package Medium;

import java.util.Arrays;

public class LongestTurbulentSubarray {
    /***
     * dp[i] : 以A[i]结尾的最长湍流的长度
     * dp[i+1] = a) dp[i] + 1   if A[i], A[i-1]符合湍流定义
     *           b) 1           else
     */
    public int maxTurbulenceSize(int[] A) {
        if (A.length <= 1)
            return A.length;
        int[] dp = new int[A.length];
        dp[0] = 1;
        dp[1] = dp[0] + (A[0] == A[1] ? 0 : 1);
        for (int i = 2; i < A.length; i++) {
            if ((A[i] > A[i - 1] && A[i - 2] > A[i - 1]) || (A[i] < A[i - 1] && A[i - 2] < A[i - 1]))
                dp[i] = dp[i - 1] + 1;
            else {
                if (A[i] == A[i - 1])
                    dp[i] = 1;
                else
                    dp[i] = 2;
            }
        }
        System.out.println(Arrays.toString(dp));
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        LongestTurbulentSubarray subarray = new LongestTurbulentSubarray();
        int[] A = {8, 9};
        System.out.println(subarray.maxTurbulenceSize(A));
    }

}
