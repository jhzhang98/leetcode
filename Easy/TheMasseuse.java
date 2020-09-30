package Easy;

public class TheMasseuse {
    public int massage(int[] nums) {
        if (nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return nums[0];
        else if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        else if (nums.length == 3)
            return Math.max(nums[0] + nums[2], nums[1]);
        int max = Math.max(nums[0] + nums[2], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];
        for (int i = 3; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        TheMasseuse masseuse = new TheMasseuse();
        int[] nums = {1, 5, 3};
        System.out.println(masseuse.massage(nums));
    }
}
