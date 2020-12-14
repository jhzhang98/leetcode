package Medium;

public class SumOfAbsoluteDifferencesInASortedArray {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] res = new int[nums.length];
        for (int i=0 ; i<nums.length ; i++)
            res[0] += nums[i] - nums[0];

        for (int i=1 ; i<nums.length ; i++)
            res[i] = res[i-1] + (2 * i - nums.length) * (nums[i] - nums[i-1]);

        return res;
    }
}
