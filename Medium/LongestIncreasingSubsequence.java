package Medium;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    /***
     * dp[i+1] = max(dp[j] + 1) for j in [0, i] && nums[i+1] > j
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    max = Math.max(dp[j], max);
            }
            dp[i] = max + 1;
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence subsequence = new LongestIncreasingSubsequence();
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(subsequence.lengthOfLIS(nums));
    }
}
