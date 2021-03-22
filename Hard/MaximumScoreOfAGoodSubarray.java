package Hard;

public class MaximumScoreOfAGoodSubarray {
    public int maximumScore(int[] nums, int k) {
        int left = k, right = k;
        int max = nums[k];
        int min = nums[k];
        while (true) {
            max = Math.max(max, min * (right - left + 1));
            if (right < nums.length - 1 && left >= 1) {
                if (nums[right + 1] > nums[left - 1]) right++;
                else left--;
            } else if (right < nums.length - 1) {
                right++;
            } else if (left >= 1) {
                left--;
            } else {
                break;
            }
            min = Math.min(Math.min(min, nums[left]), nums[right]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {5, 5, 4, 5, 4, 1, 1, 1};
        int k = 0;
        System.out.println(new MaximumScoreOfAGoodSubarray().maximumScore(nums, k));
    }
}
