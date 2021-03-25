package Offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q57 {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);
        for (int i=1 ; i<nums.length; i++){
            if (set.contains(target - nums[i]))
                return new int[]{nums[i], target - nums[i]};
            set.add(nums[i]);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {};
        int target = 0;
        System.out.println(Arrays.toString(new Q57().twoSum(nums, target)));
    }
}
