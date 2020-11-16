package Medium;

import java.util.Arrays;

public class NextPermutation {
    /***
     * 太麻烦了，不想做，说说思路
     * 从右边找一个最小数，从左找到第一个能插入位置，插入
     * 如果没有
     * 从右边找一个大数，和第一个小于它的数，插入，同时将后面的数升序排列
     */
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1)
            return;
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        NextPermutation permutation = new NextPermutation();
        int[] nums = {1, 1, 3, 4, 1};
        permutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
