package Offer;

public class Q53I {
    private int getIndex(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int index = getIndex(nums, target);
        int res = (index < 0) ? 0 : 1;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] == target) res++;
            else break;
        }
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] == target) res++;
            else break;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(new Q53I().search(nums, 10));
    }
}
