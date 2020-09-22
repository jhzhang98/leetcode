package Medium;

import java.util.Arrays;

public class MaxBlackSquare {

    int[][] score;

    public int[] findSquare(int[][] matrix) {
        score = new int[matrix.length][matrix[0].length];
        // if score[i-1][j-1] != 0 && 横竖都有score[i][j]个0 score[i][j] += 1
        // else score[i][j] = 1 if matrix[i][j] = 1 else score[i][j] = 0
        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[0].length; j++) {
                if (i - 1 < 0 || j - 1 < 0) {   // 处在第一行或者第一列
                    score[i][j] = (matrix[i][j] == 0) ? 1 : 0;
                    continue;
                }
                if (score[i - 1][j - 1] > 0 && matrix[i][j] == 0) {
                    int count = score[i - 1][j - 1];
                    boolean continueFlag = false;
                    for (int m = 0; m < count; m++) {
                        if (matrix[i - m - 1][j] != 0) {     // 向左探查
                            continueFlag = true;
                            break;
                        }
                    }
                    if (continueFlag) {
                        score[i][j] = (matrix[i][j] == 0) ? 1 : 0;
                        continue;
                    }
                    for (int n = 0; n < count; n++) {
                        if (matrix[i][j - n - 1] != 0) {     // 向上探查
                            continueFlag = true;
                            break;
                        }
                    }
                    if (continueFlag) {
                        score[i][j] = (matrix[i][j] == 0) ? 1 : 0;
                        continue;
                    }
                    score[i][j] = score[i - 1][j - 1] + 1;
                } else {
                    score[i][j] = (matrix[i][j] == 0) ? 1 : 0;
                }
            }
        }

        int biggestScore = 0;
        int x = -1, y = -1;
        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[0].length; j++) {
                if (score[i][j] > biggestScore) {
                    biggestScore = score[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        if (x == -1)
            return new int[0];
        return new int[]{x - biggestScore + 1, y - biggestScore + 1, biggestScore};
    }

    public static void main(String[] args) {
        MaxBlackSquare square = new MaxBlackSquare();
        int[][] matrix = {  {1, 0, 0, 1},
                            {1, 0, 1, 1},
                            {0, 0, 0, 1},
                            {1, 0, 0, 0}};
        System.out.println(Arrays.toString(square.findSquare(matrix)));
    }
}
