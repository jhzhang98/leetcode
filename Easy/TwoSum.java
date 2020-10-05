package Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> targetSet = new HashMap();
        for (int i = 0; i < nums.length; i++)
            targetSet.put(target - nums[i], i);
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++)
            if (targetSet.containsKey(nums[i])) {
                if (i == targetSet.get(nums[i]))
                    continue;
                res[0] = i;
                res[1] = targetSet.get(nums[i]);
                break;
            }
        return res;
    }
}
