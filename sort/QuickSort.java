package sort;

import java.util.Arrays;

public class QuickSort extends Sort {
    public int[] sort(int[] arrs) {
        quickSort(arrs, 0, arrs.length - 1);
        return arrs;
    }

    private void quickSort(int[] arrs, int l, int r) {
        if (l >= r) return;
        int head = arrs[l];
        int left = l + 1, right = r;
        while (left < right) {
            if (arrs[left] > head) {
                swap(arrs, left, right);
                right--;
            } else
                left++;
        }
        int mid = (left + right) >> 1;
        if (arrs[mid] <= head) swap(arrs, mid, l);
        else {
            swap(arrs, mid - 1, l);
            mid = mid - 1;
        }
        quickSort(arrs, l, mid - 1);
        quickSort(arrs, mid + 1, r);
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 7, 4};
        System.out.println(Arrays.toString(new QuickSort().sort(nums)));
    }
}
