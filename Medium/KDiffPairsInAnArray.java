package Medium;

import java.util.Arrays;

public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        if (nums.length <= 1)
            return 0;
        int left = 0, right = 1;
        int count = 0;
        while (left != nums.length - 1 || right != nums.length - 1) {
            int dis = nums[right] - nums[left];
            if (dis == k) {
                count++;
                while (left + 1 != nums.length && nums[left] == nums[left + 1])
                    left++;
                left = Math.min(nums.length - 1, left + 1);
                while (right + 1 != nums.length && nums[right] == nums[right + 1])
                    right++;
                right = Math.min(nums.length - 1, right + 1);
                if (right <= left)
                    right = Math.min(nums.length - 1, left + 1);
            } else if (dis > k) {
                while (left + 1 != nums.length && nums[left] == nums[left + 1])
                    left++;
                left = Math.min(nums.length - 1, left + 1);
                if (right <= left)
                    right = Math.min(nums.length - 1, left + 1);
            } else {
                while (right + 1 != nums.length && nums[right] == nums[right + 1])
                    right++;
                if (right == nums.length - 1)
                    return count;
                right = Math.min(nums.length - 1, right + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        KDiffPairsInAnArray anArray = new KDiffPairsInAnArray();
        int[] nums = {2,8,6,9,7,4,9,0,5,4};
        int k = 1;
        System.out.println(anArray.findPairs(nums, k));
    }
}
