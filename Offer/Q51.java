package Offer;

public class Q51 {
    public int reversePairs(int[] nums) {
        if (nums.length == 0) return 0;
        return merge(nums, 0, nums.length - 1);
    }

    private int merge(int[] nums, int start, int end) {
        if (end - start == 0) return 0;
        int mid = (start + end) >> 1;
        int num1 = merge(nums, start, mid);
        int num2 = merge(nums, mid + 1, end);

        //count part
        int left = start, right = mid + 1;
        int num3 = 0;
        while (left <= mid && right <= end) {
            if (nums[left] > nums[right]) {
                num3 += end - right + 1;
                left++;
            } else {
                right++;
            }
        }

        //sort part
        int[] res = new int[end - start + 1];
        int index = start;
        left = start;
        right = mid + 1;
        while (left <= mid && right <= end) {
            if (nums[left] < nums[right]) {
                res[index - start] = nums[right];
                right++;
            } else {
                res[index - start] = nums[left];
                left++;
            }
            index++;
        }

        while (left <= mid)
            res[index++ - start] = nums[left++];
        while (right <= end)
            res[index++ - start] = nums[right++];
        for (int i = start; i <= end; i++)
            nums[i] = res[i - start];

        return num1 + num2 + num3;
    }

    public static void main(String[] args) {
        int[] nums = {7, 5, 6, 4};
        System.out.println(new Q51().reversePairs(nums));
    }
}
