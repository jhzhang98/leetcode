package Medium;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] seq = new int[nums.length];
        seq[0] = nums[0];
        int maxLen = 1;
        int end = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > seq[end]) {
                seq[++end] = nums[i];
                maxLen++;
            } else if (nums[i] < seq[end]) {
                int index = search(seq, end, nums[i]);
                seq[index] = nums[i];
            }
        }
        return maxLen;
    }

    private int search(int[] seq, int end, int num) {
        int left = 0, right = end;
        int res = 0;
        if (seq[0] > num) return res;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (seq[mid] < num) {
                res = mid;
                left = mid + 1;
            } else if (seq[mid] == num)
                return mid;
            else
                right = mid - 1;
        }
        return res + 1;
    }


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
//        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        int[] nums = {4, 10, 4, 3, 8, 9};
        System.out.println(subsequence.lengthOfLIS(nums));
        System.out.println(subsequence.lengthOfLIS2(nums));
    }
}
