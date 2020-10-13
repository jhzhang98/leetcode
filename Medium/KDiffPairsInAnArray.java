package Medium;

import java.util.Arrays;

public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 1;
        int count = 0;
        while (left != right && right != nums.length - 1) {
            int dis = nums[right] - nums[left];
            if (dis == k) {
                count++;
                while (left + 1 != nums.length && nums[left] == nums[left + 1])
                    left++;
                left++;
                while (right + 1 != nums.length && nums[right] == nums[right + 1])
                    right++;
                right++;
            } else if (dis > k) {
                while (left + 1 != nums.length && nums[left] == nums[left + 1])
                    left++;
                left++;
            } else {
                while (right + 1 != nums.length && nums[right] == nums[right + 1])
                    right++;
                right++;
            }
        }
        return count;
    }
}
