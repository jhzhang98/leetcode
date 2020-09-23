package Medium;

public class SearchInRotatedSortedArray {

    private int searchHalf(int[] nums, int target, int start, int end) {
        // 跑到头了
        if (end - start == 0)
            return (nums[start] == target) ? start : -1;
        if (end - start == 1)
            return (nums[start] == target) ? start : (nums[end] == target) ? end : -1;

        int index = (start + end) / 2;
        if (nums[index] == target)
            return index;

        return Math.max(searchHalf(nums, target, start, index - 1), searchHalf(nums, target, index + 1, end));
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        return searchHalf(nums, target, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
        int[] nums = {3, 4, 5, 6, 1, 2};
        int target = 2;
        System.out.println(search.search(nums, target));
    }
}
