package Medium;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int disClosest = Integer.MAX_VALUE;
        int sign = 1;

        for (int i = 0; i < nums.length; i++) {
            if (i > 1 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }

                int tmp = nums[i] + nums[left] + nums[right] - target;
                int curDis = Math.abs(tmp);
                int curSign = tmp > 0 ? 1 : -1;
                if (curDis < disClosest) {
                    disClosest = Math.abs(curDis);
                    sign = curSign;
                }
                if (curSign > 0)
                    right--;
                else if (curSign < 0)
                    left++;
                else
                    return target;
            }
        }
        return disClosest * sign + target;
    }

    public static void main(String[] args) {
        ThreeSumClosest tsc = new ThreeSumClosest();
        int[] nums = {0, 0, 0, 0};
        int target = 0;
        System.out.println(tsc.threeSumClosest(nums, target));
    }
}
