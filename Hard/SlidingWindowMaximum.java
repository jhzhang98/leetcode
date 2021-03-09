package Hard;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // num[0]: num, num[1]: index
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        for (int i = 0; i < k; i++)
            queue.add(new int[]{nums[i], i});
        int[] res = new int[nums.length - k + 1];
        res[0] = queue.peek()[0];

        for (int i = 0; i < res.length; i++) {
            while (queue.peek()[1] >= i + k || queue.peek()[1] < i)
                queue.poll();
            if (queue.peek()[0] == nums[i])
                res[i] = queue.poll()[0];
            else
                res[i] = queue.peek()[0];
            if (i + k < nums.length)
                queue.add(new int[]{nums[i + k], i + k});
        }

        return res;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum maximum = new SlidingWindowMaximum();
        int[] nums = {4, -2};
        int k = 2;
        System.out.println(Arrays.toString(maximum.maxSlidingWindow(nums, k)));
    }
}
