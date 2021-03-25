package Offer;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q51 {
    public int reversePairs(int[] nums) {
        if (nums.length == 0)
            return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(nums[0]);
        int res = 0;
        List<Integer> tmpSave = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peek() <= nums[i])
                tmpSave.add(queue.poll());
            res += queue.size();
            queue.addAll(tmpSave);
            queue.add(nums[i]);
            tmpSave.clear();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {7, 5, 6, 4};
        System.out.println(new Q51().reversePairs(nums));
    }
}
