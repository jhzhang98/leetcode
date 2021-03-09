package Hard;

import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> wind = new ArrayList<>();
        int[] res = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        for (int i = k - 1; i >= 0; i--) {
            wind.add(0, Math.max(max, nums[i]));
            max = Math.max(max, nums[i]);
        }
        res[0] = wind.get(0);
        for (int i = 1; i < res.length; i++) {
            wind.remove(0);
            max = nums[i + k - 1];
            int removeNum = 1;
            while (wind.size() > 0 && wind.get(wind.size() - 1) < max) {
                wind.remove(wind.size() - 1);
                removeNum++;
            }
            while (removeNum-- > 0)
                wind.add(max);
            res[i] = wind.get(0);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(new SlidingWindowMaximum().maxSlidingWindow(nums, k)));
    }
}
