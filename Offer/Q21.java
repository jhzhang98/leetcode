package Offer;

public class Q21 {
    public int[] exchange(int[] nums) {
        int even = next(nums, 0, false);
        int odd = -1;

        while (even < nums.length - 1 && even >= 0) {
            odd = next(nums, even, true);
            if (odd == -1) break;
            int tmp = nums[even];
            nums[even] = nums[odd];
            nums[odd] = tmp;
            even = next(nums, even + 1, false);
        }

        return nums;
    }

    private int next(int[] nums, int start, boolean findEven) {
        for (int i = start; i < nums.length; i++) {
            if (findEven) {
                if (nums[i] % 2 == 1)
                    return i;
            } else {
                if (nums[i] % 2 == 0)
                    return i;
            }
        }
        return -1;
    }
}
