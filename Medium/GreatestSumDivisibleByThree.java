package Medium;

public class GreatestSumDivisibleByThree {
    public int maxSumDivThree(int[] nums) {
        int[][] dp = new int[3][nums.length];
        int index = nums[0] % 3;
        dp[index][0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tail = nums[i] % 3;
            if (tail == 0) {
                for (int j = 0; j < 3; j++)
                    dp[j][i] = dp[j][i - 1] + nums[i];
            } else if (tail == 1) {
                for (int j = 0; j < 3; j++) {
                    int srcIndex = (j + 3 - tail) % 3;
                    if (dp[srcIndex][i - 1] % 3 == srcIndex)
                        dp[j][i] = Math.max(dp[j][i - 1], dp[srcIndex][i - 1] + nums[i]);
                    else
                        dp[j][i] = dp[j][i - 1];
                }
            } else if (tail == 2) {
                for (int j = 0; j < 3; j++) {
                    int srcIndex = (j + 3 - tail) % 3;
                    if (dp[srcIndex][i - 1] % 3 == srcIndex)
                        dp[j][i] = Math.max(dp[j][i - 1], dp[srcIndex][i - 1] + nums[i]);
                    else
                        dp[j][i] = dp[j][i - 1];
                }
            }
        }

        return dp[0][nums.length - 1];
    }

    public static void main(String[] args) {
        GreatestSumDivisibleByThree three = new GreatestSumDivisibleByThree();
        int[] nums = {3, 6, 5, 1, 8};
        System.out.println(three.maxSumDivThree(nums));
    }
}
