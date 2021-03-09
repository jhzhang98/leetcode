package Easy;

public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int window = 0;
        for (int i = 0; i < k; i++)
            window += nums[i];
        double maxMedian = window * 1.0 / k;
        for (int i = k; i < nums.length; i++) {
            window -= nums[i - k];
            window += nums[i];
            maxMedian = Math.max(window * 1.0 / k, maxMedian);
        }
        return maxMedian;
    }

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(new MaximumAverageSubarrayI().findMaxAverage(nums, k));
    }
}
