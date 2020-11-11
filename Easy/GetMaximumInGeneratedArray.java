package Easy;

import java.util.Arrays;

public class GetMaximumInGeneratedArray {
    public int getMaximumGenerated(int n) {
        if (n == 0)
            return 0;
        int[] nums = new int[n + 1];
        Arrays.fill(nums, -1);
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 1; i < n + 1; i++) {
            if (2 * i >= 2 && 2 * i <= n)
                nums[2 * i] = nums[i];
            if (2 * i + 1 >= 2 && 2 * i + 1 <= n)
                nums[2 * i + 1] = nums[i] + nums[i + 1];
        }
        return Arrays.stream(nums).max().getAsInt();
    }
}
