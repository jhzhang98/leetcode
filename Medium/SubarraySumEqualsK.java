package Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SubarraySumEqualsK {
    /**
     * Si = sum_0^i{nums[i]}
     * k = Sj - Si
     * Si + k = Sj
     * build Set = {Si + k | 0 <= i < nums.length}
     * for each Sj in
     * 有 bug，不想改了
     */
    public int subarraySum2(int[] nums, int k) {
        int resNum = 0;
        if (nums.length == 0)
            return resNum;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            sum[i] = sum[i - 1] + nums[i];

        Set<Integer> set = new HashSet<>();
        for (int val : sum)
            set.add(val + k);
        if (nums[0] == k)
            resNum++;

        for (int i = 1; i < nums.length; i++)
            if (set.contains(sum[i]))
                resNum++;
        return resNum;
    }


    public int subarraySum(int[] nums, int k) {
        int resNum = 0;
        if (nums.length == 0)
            return resNum;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            sum[i] = sum[i - 1] + nums[i];

        for (int i = 0; i < nums.length; i++) {
            if (sum[i] == k)
                resNum++;
            for (int j = i + 1; j < nums.length; j++) {
                if (sum[j] - sum[i] == k)
                    resNum++;
            }
        }
        return resNum;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK equalsK = new SubarraySumEqualsK();
        int[] nums = {0, 1, 0};
        int k = 0;
        System.out.println(equalsK.subarraySum2(nums, k));
    }
}
