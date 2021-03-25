package Offer;

import java.util.Arrays;

public class Interview1724 {
    int m, n;

    public int[] getMaxMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int maxSum = matrix[0][0];
        int r1 = 0, c1 = 0;
        int r2 = 0, c2 = 0;

        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                int[] prefix = getPrefix(matrix, i, j);
                int[] maxIndex = maxSeqSum(prefix);
                int sum = maxIndex[2];
                if (sum > maxSum) {
                    r1 = i;
                    r2 = j;
                    c1 = maxIndex[0];
                    c2 = maxIndex[1];
                    maxSum = sum;
                }
            }
        }

        return new int[]{r1, c1, r2, c2};
    }

    private int[] maxSeqSum(int[] prefix) {
        int sumMax = prefix[0];
        int preSum = prefix[0];
        int curMin = Math.min(0, prefix[0]);
        int curMinIndex = (curMin == prefix[0]) ? 0 : -1;
        int[] res = {0, 0, sumMax};
        for (int i = 1; i < n; i++) {
            preSum += prefix[i];

            if (preSum - curMin > sumMax) {
                sumMax = preSum - curMin;
                res[0] = curMinIndex + 1;
                res[1] = i;
                res[2] = sumMax;
            }
            if (preSum < curMin) {
                curMin = preSum;
                curMinIndex = i;
            }
        }
        return res;
    }

    private int[] getPrefix(int[][] matrix, int rowStart, int rowEnd) {
        int[] res = new int[n];
        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = 0; j < n; j++)
                res[j] += matrix[i][j];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, -8, 1, 3, -2}, {-3, 7, -2, -2, 4}, {6, -4, -4, 8, -7}, {-6, 4, 4, 2, 7}};
        System.out.println(Arrays.toString(new Interview1724().getMaxMatrix(nums)));
    }
}
