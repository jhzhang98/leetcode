package Offer;

import java.util.Arrays;

public class Interview1719 {
    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    public int[] missingTwo(int[] nums) {
        int n1 = -1, n2 = -1;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1)  continue;
            if (i != nums[i] - 1) {
                if (nums[i] - 1 >= n) {
                    if (nums[i] - 1 == n)
                        n1 = nums[i];
                    else
                        n2 = nums[i];
                    nums[i] = -1;
                } else {
                    swap(nums, i, nums[i] - 1);
                    i--;
                }
            }
        }
        int[] res = new int[2];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1)
                res[index++] = i + 1;
        }
        if (n1 == -1) res[index++] = n + 1;
        if (n2 == -1) res[index] = n + 2;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(Arrays.toString(new Interview1719().missingTwo(nums)));
    }
}
