package Medium;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    int target;

    int search(int[] nums, int start, int end) {
        int index = (start + end) / 2;
        if (end - start == 1)
            return (nums[end] == target) ? end : (nums[start] == target) ? start : -1;
        else if (end - start == 0)
            return (nums[end] == target) ? end : -1;

        if (nums[index] > target) {
            index = (start + index) / 2;
        } else if (nums[index] < target) {
            index = (index + end) / 2;
        } else
            return index;
        if (nums[index] == target)
            return index;
        else if (nums[index] > target) {
            if (index == end)
                return -1;
            return search(nums, start, index);
        } else {
            if (index == start)
                return -1;
            return search(nums, index, end);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};
        this.target = target;
        int index = search(nums, 0, nums.length - 1);
        if (index == -1)
            return new int[]{-1, -1};
        else {
            int start = index, end = index;
            while (start >= 0 && nums[start] == target)
                start--;
            while (end < nums.length && nums[end] == target)
                end++;
            return new int[]{start + 1, end - 1};
        }
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray sortedArray = new FindFirstAndLastPositionOfElementInSortedArray();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 5, 5, 5, 5, 5, 5, 6};
        int target = 4;
        System.out.println(Arrays.toString(sortedArray.searchRange(nums, target)));
    }
}
