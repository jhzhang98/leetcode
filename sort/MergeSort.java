package sort;

import java.util.Arrays;

public class MergeSort extends Sort {

    public int[] sort(int[] attrs) {
        mergeSort(attrs, 0, attrs.length - 1);
        return attrs;
    }

    private void mergeSort(int[] attrs, int l, int r) {
        if (l < r) {
            int mid = (l + r) >> 1;
            mergeSort(attrs, l, mid);
            mergeSort(attrs, mid + 1, r);
            merge(attrs, l, mid, mid + 1, r);
        }
    }

    private void merge(int[] attrs, int la, int ra, int lb, int rb) {
        int[] attr1 = new int[ra - la + 1];
        int[] attr2 = new int[rb - lb + 1];
        System.arraycopy(attrs, la, attr1, 0, ra + 1 - la);
        System.arraycopy(attrs, lb, attr2, 0, rb + 1 - lb);
        int left = 0, right = 0;
        int index = la;
        while (left < attr1.length && right < attr2.length) {
            if (attr1[left] < attr2[right]) {
                attrs[index++] = attr1[left++];
            } else {
                attrs[index++] = attr2[right++];
            }
        }
        while(left < attr1.length)
            attrs[index++] = attr1[left++];
        while(right < attr2.length)
            attrs[index++] = attr2[right++];
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 7, 4};
        System.out.println(Arrays.toString(new MergeSort().sort(nums)));
    }
}
