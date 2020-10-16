package Easy;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums2Index = n - 1;
        int nums1Index = m - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (nums1Index >= 0 && (nums2Index < 0 || nums1[nums1Index] > nums2[nums2Index])) {
                nums1[i] = nums1[nums1Index];
                nums1Index--;
            } else {
                nums1[i] = nums2[nums2Index];
                nums2Index--;
            }
        }
    }
}
