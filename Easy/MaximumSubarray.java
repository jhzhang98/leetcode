package Easy;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSub = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSub = Math.max(dp[i], maxSub);
        }
        return maxSub;
    }

    public static void main(String[] args) {
        MaximumSubarray subarray = new MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(subarray.maxSubArray(nums));
    }
}
