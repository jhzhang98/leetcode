package Easy;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] numsSorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsSorted);
        int start = 0, end = nums.length - 1;
        while (start < nums.length && numsSorted[start] == nums[start])
            start++;
        while (numsSorted[end] == nums[end]) {
            end--;
            if (end <= start)
                return 0;
        }
        if (end > start)
            return end - start + 1;
        else
            return 0;
    }

    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray subarray = new ShortestUnsortedContinuousSubarray();
        int[] nums = {4, 6, 2, 8, 10, 9, 15};
        System.out.println(subarray.findUnsortedSubarray(nums));
    }
}
