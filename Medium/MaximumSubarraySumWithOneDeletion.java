package Medium;

import java.util.Arrays;

public class MaximumSubarraySumWithOneDeletion {
    /***
     * full[i]表示以arr[i]结尾的全都要子序列和
     * full[i] = max(full[i-1] + arr[i], arr[i])
     *
     * del[i]表示以arr[i]结尾的删除一个元素的子序列和
     * 因为只有两种情况，从不删的子序列中删掉arr[i]，另一种是维持之前删除的元素
     * del[i] = max(del[i-1] + arr[i], full[i-1] + arr[i] - arr[i]
     *
     * res = max(full.max, del.max)
     * 这样看来，O(1)的空间就足够，因为只需要上一次的值，不需要历史值
     */
    public int maximumSum(int[] arr) {
        int[] full = new int[arr.length];
        int[] del = new int[arr.length];
        full[0] = arr[0];
        del[0] = Integer.MIN_VALUE >> 2; //只能删掉自己，但是又不能一个元素都没有，所以直接搞成最小

        for (int i = 1; i < arr.length; i++) {
            full[i] = Math.max(full[i - 1] + arr[i], arr[i]);
            del[i] = Math.max(del[i - 1] + arr[i], full[i - 1]);
        }

        return Math.max(Arrays.stream(full).max().getAsInt(), Arrays.stream(del).max().getAsInt());
    }

    public static void main(String[] args) {
        MaximumSubarraySumWithOneDeletion deletion = new MaximumSubarraySumWithOneDeletion();
        int[] arr = {11, -10, -11, 8, 7, -6, 9, 4, 11, 6, 5, 0};
        System.out.println(deletion.maximumSum(arr));
    }
}
