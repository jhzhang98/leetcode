package Medium;

public class ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) { // 保证最高位为1
                for (int j = 0; j < A[0].length; j++)
                    A[i][j] = 1 - A[i][j];
            }
        }

        for (int j = 0; j < A[0].length; j++) {
            int zeroNum = 0;
            for (int[] row : A) zeroNum += (row[j] == 0) ? 1 : 0;
            if (zeroNum > (A.length / 2)) {     // 0的数目比1多
                for (int i = 0; i < A.length; i++) {
                    A[i][j] = 1 - A[i][j];
                }
            }
        }
        int sum = 0;
        int[] powerTwo = new int[A[0].length];
        powerTwo[powerTwo.length - 1] = 1;
        for (int i = powerTwo.length - 2; i >= 0; i--)
            powerTwo[i] = 2 * powerTwo[i + 1];

        for (int[] row : A) {
            for (int j = 0; j < A[0].length; j++) {
                sum += powerTwo[j] * row[j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ScoreAfterFlippingMatrix matrix = new ScoreAfterFlippingMatrix();
        int[][] A = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        System.out.println(matrix.matrixScore(A));
    }
}
