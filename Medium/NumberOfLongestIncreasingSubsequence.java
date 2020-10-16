package Medium;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {

    /***
     * 初始所有dp为 1
     * dp_len[i] 表示以nums[i]结尾的递增子序列的长
     * for k < i && nums[i] > nums[k]
     * dp_len[i] = max(dp_len[i], dp_count[k] + 1)
     *
     * dp_count[i] 表示以nums[i]结尾的递增子序列个数
     * for k < i && nums[i] > nums[k]
     * if (dp_len[k] + 1 == dp_len[i])    // 碰到另一个符合的子序列，个数+dp_count[k]
     *      dp_count[i] = dp_count[i] + dp_count[j]
     * else if (dp_len[k] + 1 > dp_len[i]) // 碰到一个符合的子序列，更新
     *      dp_count[i] = max(dp_count[i], dp_count[k])
     */
    public int findNumberOfLIS(int[] nums) {
        int[] dp_len = new int[nums.length];
        int[] dp_count = new int[nums.length];
        Arrays.fill(dp_len, 1);
        Arrays.fill(dp_count, 1);
        if (nums.length <= 1)
            return nums.length;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp_len[i] = Math.max(dp_len[i], dp_len[j] + 1);
                    max = Math.max(dp_len[i], max);
                }
            }
            dp_count[i] -= 1;   // 第一个碰到的属于第一个序列，所以在开始时减一
            for (int j=0 ; j<i ; j++){
                if (nums[i] > nums[j]){
                    if (dp_len[j] + 1 == dp_len[i]) {
                        dp_count[i] += dp_count[j];
                    }
                }
            }
            // 如果没有递增序列，置为1
            if(dp_count[i] == 0)
                dp_count[i] = 1;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp_len[i] == max)
                count += dp_count[i];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,7,2,4,6,8};
        System.out.println(new NumberOfLongestIncreasingSubsequence().findNumberOfLIS(nums));
    }
}
