package Medium;

import java.util.Arrays;

public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length - 1; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        int max = dp[nums.length - 2];
        Arrays.fill(dp, 0);
        dp[1] = nums[1];
        dp[2] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < nums.length; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        return Math.max(max, dp[nums.length - 1]);
    }

    public static void main(String[] args) {
        HouseRobberII robberII = new HouseRobberII();
        int[] nums = {2, 2, 4, 3, 2, 5};
        System.out.println(robberII.rob(nums));
    }
}
