package Medium;

import java.util.*;

public class NextPermutation {
    /***
     * 从后往前判断
     * 找出j > i 时大于num[i]的最小的数
     * 代替之，后将剩余数从小到大排列，放入nums[i]后面
     */
    public void nextPermutation(int[] nums) {
        if (nums.length == 1)
            return;
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        queue.add(nums[nums.length - 1]);
        int max = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (max > nums[i]) {
                queue.add(nums[i]);
                int justBigger = Integer.MAX_VALUE;
                Queue<Integer> bak = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
                bak.addAll(queue);
                while (!bak.isEmpty()) {
                    int num = bak.poll();
                    if (num > nums[i])
                        justBigger = Math.min(justBigger, num);
                }
                nums[i] = justBigger;
                boolean removed = false; //
                for (int j = nums.length - 1; j > i; j--) {
                    int num = queue.poll();
                    if (!removed && num == justBigger) {
                        removed = true;
                        j++;
                        continue;
                    }
                    nums[j] = num;
                }
                return;
            } else {
                max = Math.max(max, nums[i]);
                queue.add(nums[i]);
            }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        NextPermutation permutation = new NextPermutation();
        int[] nums = {1, 1, 5};
        permutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
