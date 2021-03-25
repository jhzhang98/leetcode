package Offer;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Q59I {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0)
            return new int[0];
        Deque<Integer> queue = new LinkedList<>();
        queue.add(nums[0]);
        for (int i = 1; i < k; i++) {
            while (!queue.isEmpty() && nums[i] > queue.peekLast())
                queue.pollLast();
            queue.add(nums[i]);
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = k; i < nums.length; i++) {
            res[i - k] = queue.peek();
            if (queue.peek() == nums[i - k])    // 弹出窗口滑走的元素
                queue.poll();
            while (!queue.isEmpty() && nums[i] > queue.peekLast())  // 判断新添加的元素是否为最大
                queue.pollLast();
            queue.add(nums[i]);
        }
        res[nums.length - k] = queue.peek();
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(new Q59I().maxSlidingWindow(nums, k)));
    }
}
