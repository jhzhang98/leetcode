package Easy;

import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanOrEqualX {
    public int specialArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int max = nums[nums.length - 1];

        for (int i = 1; i <= max && i <= nums.length; i++) {
            if (i == nums.length) {
                if (nums[0] >= i)
                    return i;
            } else if (nums[nums.length - i] >= i && nums[nums.length - i - 1] < i)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        SpecialArrayWithXElementsGreaterThanOrEqualX equalX = new SpecialArrayWithXElementsGreaterThanOrEqualX();
//        int[] nums = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100};
        int[] nums = {3, 3, 3};
        System.out.println(equalX.specialArray(nums));
    }
}
