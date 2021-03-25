package Offer;

import java.util.Arrays;

public class Q61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int joker = 0;
        int vacant = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0)
                joker++;
            else if (nums[i] == nums[i + 1])
                return false;
            else if (nums[i] - nums[i + 1] != -1)
                vacant += (nums[i + 1] - nums[i] - 1);
        }
        return vacant <= joker;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 2, 2, 5};
        System.out.println(new Q61().isStraight(nums));
    }
}
