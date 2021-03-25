package weekly.w233;

public class Q1 {
    public int maxAscendingSum(int[] nums) {
        int right = 1;
        int maxSum = nums[0];
        int localSum = nums[0];
        while (right < nums.length) {
            if (nums[right] > nums[right - 1]) {
                localSum += nums[right];
            } else {
                localSum = nums[right];
            }
            maxSum = Math.max(maxSum, localSum);
            right++;
        }
        return maxSum;
    }
    public static void main(String[] args) {

    }
}
