package Medium;

import java.util.Arrays;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        int[] sub = new int[nums.length];
        for (int i = 1; i < sub.length; i++)
            sub[i] = nums[i] - nums[i - 1];
        dp[0] = 0;
        int lastPosInd = -1, lastNegInd = -1;

        for (int i = 1; i < nums.length; i++) {
            if (sub[i] > 0) {
                if (lastNegInd != -1)
                    dp[i] = dp[lastNegInd] + 1;
                else
                    dp[i] = 1;
                lastPosInd = i;
            } else if (sub[i] < 0) {
                if (lastPosInd != -1)
                    dp[i] = dp[lastPosInd] + 1;
                else
                    dp[i] = 1;
                lastNegInd = i;
            } else {
                dp[i] = 0;
            }
        }
        return Arrays.stream(dp).max().getAsInt() + 1;
    }

    public static void main(String[] args) {
        WiggleSubsequence subsequence = new WiggleSubsequence();
        int[] nums = {1,1,1,2,2,2,1,1,1,3,3,3,2,2,2};
        System.out.println(subsequence.wiggleMaxLength(nums));
    }
}
