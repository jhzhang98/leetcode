package Medium;

public class WaysToMakeAFairArray {
    public int waysToMakeFair(int[] nums) {
        int delIndex = 0;
        int[] dp_even = new int[nums.length];
        int[] dp_odd = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 1) {//是奇为偶
                dp_even[delIndex] += nums[i];
            } else {
                dp_odd[delIndex] += nums[i];
            }
        }

        for (delIndex = 1; delIndex < nums.length; delIndex++) {
            if (delIndex % 2 == 0) {
                dp_even[delIndex] = dp_even[delIndex - 1];
                dp_odd[delIndex] = dp_odd[delIndex - 1] + (nums[delIndex - 1] - nums[delIndex]);
            } else {
                dp_even[delIndex] = dp_even[delIndex - 1] + (nums[delIndex - 1] - nums[delIndex]);
                dp_odd[delIndex] = dp_odd[delIndex - 1];
            }
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp_even[i] == dp_odd[i])
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        WaysToMakeAFairArray aFairArray = new WaysToMakeAFairArray();
        int[] nums = {1};
        System.out.println(aFairArray.waysToMakeFair(nums));
    }
}
