package Hard;

import java.util.Arrays;

public class CreateMaximumNumber {
    int[] nums1, nums2;
    int[] res;
    boolean resInit = true;

    /***
     * 超时，爷不做了
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.res = new int[k];
        getNextNum(0, 0, new int[k], k);
        return res;
    }

    private boolean checkBigger(int[] nums, int len) {
        for (int i = 0; i < len; i++)
            if (nums[i] < res[i])
                return false;
            else if (nums[i] > res[i])
                return true;
        return true;
    }

    private void getNextNum(int start1, int start2, int[] nums, int k) {
        if (k == 0) {
            if (resInit) {
                this.res = nums;
                resInit = false;
            }
            if (checkBigger(nums, nums.length))
                this.res = nums;
            return;
        }

        int edge1 = (nums2.length - start2 >= k - 1) ? nums1.length : nums1.length + (nums2.length - start2) - (k - 1);
        int edge2 = (nums1.length - start1 >= k - 1) ? nums2.length : nums2.length + (nums1.length - start1) - (k - 1);
        int max1 = -1, index1 = -1;
        if (start1 < nums1.length) {
            max1 = nums1[start1];
            index1 = start1;
            for (int i = start1 + 1; i < edge1; i++) {
                if (nums1[i] > max1) {
                    max1 = nums1[i];
                    index1 = i;
                }
            }
        }
        int max2 = -1, index2 = -1;
        if (start2 < nums2.length) {
            max2 = nums2[start2];
            index2 = start2;
            for (int i = start2 + 1; i < edge2; i++) {
                if (nums2[i] > max2) {
                    max2 = nums2[i];
                    index2 = i;
                }
            }
        }
        nums[nums.length - k] = Math.max(max1, max2);
        if (!resInit && !checkBigger(nums, nums.length - k + 1))
            return;
        if (max1 > max2)
            getNextNum(index1 + 1, start2, nums, k - 1);
        else if (max1 < max2)
            getNextNum(start1, index2 + 1, nums, k - 1);
        else {
            int[] copy = Arrays.copyOf(nums, nums.length);
            getNextNum(index1 + 1, start2, nums, k - 1);
            getNextNum(start1, index2 + 1, copy, k - 1);
        }
    }

    public static void main(String[] args) {
        CreateMaximumNumber number = new CreateMaximumNumber();
        int[] nums1 = {1, 0, 1, 0, 3};
        int[] nums2 = {0, 1, 0, 5};
        int k = nums1.length + nums2.length;
        System.out.println(Arrays.toString(number.maxNumber(nums1, nums2, k)));
    }
}
