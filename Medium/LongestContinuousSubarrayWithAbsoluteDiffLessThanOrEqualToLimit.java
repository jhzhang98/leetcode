package Medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0, right = 0;
        PriorityQueue<int[]> small = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> big = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0], o1[0]));
        int maxLen = 1;
        while (right < nums.length) {
            big.add(new int[]{nums[right], right});
            small.add(new int[]{nums[right], right});
            while (!small.isEmpty() && !big.isEmpty() && big.peek()[0] - small.peek()[0] > limit) {
                left += 1;
                while (!small.isEmpty() && small.peek()[1] < left)
                    small.poll();
                while (!big.isEmpty() && big.peek()[1] < left)
                    big.poll();
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 2, 2, 4, 4, 2, 2};
        int limit = 0;
        System.out.println(new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit().longestSubarray(nums, limit));
    }
}
