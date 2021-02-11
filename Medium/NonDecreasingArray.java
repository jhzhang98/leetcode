package Medium;

public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        if (nums.length <= 2)
            return true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return check(nums, i) || check(nums, i - 1);
            }
        }
        return true;
    }

    private boolean check(int[] nums, int delIndex) {
        int last = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i == delIndex)
                continue;
            if (nums[i] < last)
                return false;
            last = nums[i];
        }
        return true;
    }
}
