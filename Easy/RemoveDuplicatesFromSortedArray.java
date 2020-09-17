package Easy;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray remove = new RemoveDuplicatesFromSortedArray();
        int[] nums = {};
        System.out.println(remove.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
