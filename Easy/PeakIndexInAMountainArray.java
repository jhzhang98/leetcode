package Easy;

public class PeakIndexInAMountainArray {
    private int findMax(int[] arr, int start, int end) {
        if (end <= start) return start;
        if (end - start == 1) return arr[start] > arr[end] ? start : end;
        int mid = (start + end) >> 1;
        if ((arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])) {
            int left = findMax(arr, start, mid - 1);
            int right = findMax(arr, mid, end);
            return arr[left] > arr[right] ? left : right;
        } else if (arr[mid] > arr[mid - 1]) {
            int index = findMax(arr, mid + 1, end);
            return arr[mid] > arr[index] ? mid : index;
        } else if (arr[mid] < arr[mid - 1]) {
            return findMax(arr, start, mid - 1);
        } else {
            int left = findMax(arr, start, mid - 1);
            int right = findMax(arr, mid + 1, end);
            return arr[left] > arr[right] ? left : right;
        }

    }

    public int peakIndexInMountainArray(int[] arr) {
        return findMax(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 4, 2, 2, 8};
        System.out.println(new PeakIndexInAMountainArray().peakIndexInMountainArray(arr));
    }
}
