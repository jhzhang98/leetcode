package Medium;

public class TargetSum {
    int count = 0;

    private void curSum(int[] nums, int curIndex, int curSum, int target, boolean add) {
        int sum;
        if (add)
            sum = curSum + nums[curIndex];
        else
            sum = curSum - nums[curIndex];

        if (curIndex == nums.length - 1)
            count += target == sum ? 1 : 0;
        else {
            curSum(nums, curIndex + 1, sum, target, true);
            curSum(nums, curIndex + 1, sum, target, false);
        }
    }

    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0)
            return 0;
        curSum(nums, 0, 0, S, true);
        curSum(nums, 0, 0, S, false);
        return count;
    }

    public static void main(String[] args) {
        TargetSum sum = new TargetSum();
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(sum.findTargetSumWays(nums, S));
    }
}
