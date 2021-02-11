package Offer;

import java.util.Arrays;

public class Q29 {
    public int[] spiralOrder(int[][] matrix) {
        int[] res = new int[matrix.length * matrix[0].length];
        int up = 0, right = matrix[0].length - 1, down = matrix.length - 1, left = 0;
        int index = 0;
        while (true) {
            for (int j = left; j <= right; j++)
                res[index++] = matrix[up][j];
            up++;
            if (index == res.length)
                break;
            for (int i = up; i <= down; i++)
                res[index++] = matrix[i][right];
            right--;
            if (index == res.length)
                break;
            for (int j = right; j >= left; j--)
                res[index++] = matrix[down][j];
            down--;
            if (index == res.length)
                break;
            for (int i= down ; i >= up ; i--)
                res[index++] = matrix[i][left];
            left++;
            if (index == res.length)
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(Arrays.toString(new Q29().spiralOrder(matrix)));
    }
}
