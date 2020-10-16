package Easy;

public class LongestContinuousIncreasingSubsequence {
    /***
     * dp[i] 表示以nums[i]为尾数的最长连续递增子序列长度
     * dp[i+1] = dp[i] + 1 if nums[i+1] > nums[i]
     *           1 else
     */
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length] ;
        if (nums.length <= 1)
            return nums.length;
        dp[0] = 1;
        int max = 1;
        for (int i=1 ; i<nums.length ;i++){
            if (nums[i] > nums[i-1]) {
                dp[i] = dp[i - 1] + 1;
                max = Math.max(dp[i], max);
            }
            else
                dp[i] = 1;
        }
        return max;
    }
}
