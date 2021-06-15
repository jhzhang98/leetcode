package weekly.w238;

import java.util.*;

public class Q2 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 0;
        long curCost = 0;
        int max = 1;

        while (right < nums.length) {
            if (left == right) {
                right++;
                continue;
            }
            long preLen = right - left;
            long tmpCost = curCost + (nums[right] - nums[right - 1]) * preLen;
            while (tmpCost > k) {
                tmpCost -= nums[right] - nums[left];
                left++;
            }
            curCost = tmpCost;
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int k = 5;
        System.out.println(new Q2().maxFrequency(nums, k));
    }
}
