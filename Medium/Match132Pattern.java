package Medium;

import java.util.Stack;

public class Match132Pattern {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        int[] minArrayLeft = new int[nums.length];
        minArrayLeft[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            minArrayLeft[i] = Math.min(nums[i], minArrayLeft[i - 1]);

        Stack<Integer> stack = new Stack<>();
        stack.add(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 1; i--) {
            int bigger = Integer.MIN_VALUE;
            while (!stack.isEmpty() && stack.peek() < nums[i])
                bigger = stack.pop();
            if (nums[i] > bigger && bigger > minArrayLeft[i])
                return true;
            stack.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 0, -1, -2, -3, -1, -2};
        System.out.println(new Match132Pattern().find132pattern(nums));
    }
}
