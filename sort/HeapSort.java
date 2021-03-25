package sort;

import java.util.Arrays;

public class HeapSort extends Sort {
    private void heapify(int[] arr, int root, int len) {
        int maxIndex = root;
        int left = root * 2 + 1, right = root * 2 + 2;

        if (left < len && arr[left] > arr[maxIndex])
            maxIndex = left;
        if (right < len && arr[right] > arr[maxIndex])
            maxIndex = right;

        if (maxIndex == root) return;
        swap(arr, root, maxIndex);
        heapify(arr, maxIndex, len);
    }

    public int[] sort(int[] attrs) {
        int n = attrs.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(attrs, i, n);

        for (int i = n - 1; i >= 0; i--) {
            swap(attrs, 0, i);
            heapify(attrs, 0, i);
        }

        return attrs;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 7, 4};
        System.out.println(Arrays.toString(new HeapSort().sort(nums)));
    }
}
