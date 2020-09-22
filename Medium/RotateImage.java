package Medium;

import java.util.Arrays;

public class RotateImage {
    public void rotate(int[][] matrix) {
        //1. 转置
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        //2. 调换
        for (int j = 0; j < matrix.length / 2; j++) {
            for (int i = 0; i < matrix.length; i++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        RotateImage rotate = new RotateImage();
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotate.rotate(matrix);
        for (int[] line : matrix)
            System.out.println(Arrays.toString(line));
    }
}
