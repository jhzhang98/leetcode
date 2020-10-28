package Medium;

public class LongestMountainInArray {
    public int longestMountain(int[] A) {
        int start = 0;
        boolean up = false;
        boolean down = false;
        int end = start + 1;
        int longestDis = 0;
        while (start < A.length && end < A.length) {
            if (A[end] > A[end - 1] && !down) { // 如果当前不在下山，并且在增加，说明在爬山
                up = true;
                end++;
            } else if (A[end] < A[end - 1] && !down && up) { // 当前爬到山顶，该下山了
                down = true;
                end++;
            } else if (A[end] < A[end - 1] && down && up) {  // 当前在下山
                end++;
            } else {    //说明爬到底或者出现问题结束了
                if (up && down) { // 说明山峰完整
                    longestDis = Math.max(longestDis, end - start);
                    start = end - 1; // 这个时候，start到山脚下，因为山脚可能是下一个山峰的开始
                } else {
                    start = end;
                }
                end = start + 1;
                up = false;
                down = false;
            }
        }

        if (up && down)
            longestDis = Math.max(longestDis, end - start);
        return longestDis;
    }

    public static void main(String[] args) {
        LongestMountainInArray array = new LongestMountainInArray();
        int[] A = {2, 1, 100, 99, 2, 3, 4, 5, 4};
        System.out.println(array.longestMountain(A));
    }
}
