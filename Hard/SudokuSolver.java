package Hard;

import java.util.*;

public class SudokuSolver {
    /**
     * 记录每个空格处可能存在的数值，
     * 用二进制表示，如010001001表示可能为1，4，8
     * 只有两种情况，
     * 1）某个空格只有一种备选
     * 2）某个空格只有它要特定数字（在某一列或某一行或某个九宫）
     * 3）其他情况随意填一个备选即可
     */
    public void solveSudoku(char[][] board) {
        boolean[] row = new boolean[board.length];
        boolean[] col = new boolean[board.length];
        boolean[] subBox = new boolean[board.length];
        Arrays.fill(row, true);
        Arrays.fill(col, true);
        Arrays.fill(subBox, true);

        Map<Integer, Integer> binaryToD = initMap(); // 记录二进制表示对应的数字
        int[] decimalToB = {-1, 0b1, 0b10, 0b100, 0b1000, 0b10000, 0b100000, 0b1000000, 0b10000000, 0b100000000};

        int[][] filledBoard = checkFilled(board);
        int[][] state = initState(board, filledBoard, decimalToB);

        while (!checkFinished(board)) {
            // 1. 检查state中是否有只有一个备选的，更新之
            for (int i = 0; i < state.length; i++) {
                if (!row[i])
                    continue;
                for (int j = 0; j < state.length; j++) {
                    if (!col[i])
                        continue;
                    if (binaryToD.containsKey(state[i][j])) {
                        board[i][j] = (char) ('0' + binaryToD.get(state[i][j]));
                        updateState(i, j, state, state[i][j]);
                    }
                }
            }
            // 2. 检查state中是否有它是唯一的，更新之
            for (int i = 0; i < state.length; i++) {  //逐行检查
                if (!row[i])
                    continue;

                int mask = 0b111111111;
                for (int j = 0; j < state.length; j++)
                    mask &= state[i][j];                // 求公共数字

                boolean noUpdate = true;
                for (int j = 0; j < state.length; j++) {
                    if (state[i][j] == 0)
                        continue;
                    int tmp = state[i][j] ^ mask;       // 利用异或操作，求出不公共数字，若只有一个，则更新state
                    if (binaryToD.containsKey(tmp)) {
                        board[i][j] = (char) ('0' + binaryToD.get(tmp));
                        updateState(i, j, state, tmp);
                        noUpdate = false;
                        col[i] = true;
                        int boxNum = i / 3 * 3 + j / 3;
                        subBox[boxNum] = true;
                    }
                }
                row[i] = !noUpdate;
            }

            for (int j = 0; j < state.length; j++) {   //逐行检查
                if (!col[j])
                    continue;

                int mask = 0b111111111;
                for (int[] line : state) mask &= line[j];

                boolean noUpdate = true;
                for (int i = 0; i < state.length; i++) {
                    if (state[i][j] == 0)
                        continue;
                    int tmp = state[i][j] ^ mask;
                    if (binaryToD.containsKey(tmp)) {
                        board[i][j] = (char) ('0' + binaryToD.get(tmp));
                        updateState(i, j, state, tmp);
                        noUpdate = false;
                        row[i] = true;
                        int boxNum = i / 3 * 3 + j / 3;
                        subBox[boxNum] = true;
                    }
                }

                col[j] = !noUpdate;
            }

            for (int m = 0; m < 3; m++) {
                for (int n = 0; n < 3; n++) {
                    int boxNum = m * 3 + n;
                    if (!subBox[boxNum])
                        continue;

                    int mask = 0b111111111;
                    for (int i = m * 3; i < m * 3 + 3; i++) {
                        for (int j = n * 3; j < n * 3 + 3; j++)
                            mask &= state[i][j];
                    }
                    boolean noUpdate = true;
                    for (int i = m * 3; i < m * 3 + 3; i++) {
                        for (int j = n * 3; j < n * 3 + 3; j++) {
                            if (state[i][j] == 0)
                                continue;
                            int tmp = mask ^ state[i][j];
                            if (binaryToD.containsKey(tmp)) {
                                board[i][j] = (char) ('0' + binaryToD.get(tmp));
                                updateState(i, j, state, tmp);
                                noUpdate = false;
                                row[i] = true;
                                col[j] = true;
                            }
                        }
                    }
                    subBox[boxNum] = !noUpdate;
                }
            }

            // 3. 随便填一个
            for (int i = 0; i < state.length; i++) {
                for (int j = 0; j < state.length; j++) {
                    if (state[i][j] == 0)
                        continue;
                    int num = state[i][j];
                    int count = 0;
                    while (num != 1) {
                        num >>= 1;
                        count++;
                    }
                    num = 1 << count;
                    board[i][j] = (char) ('0' + binaryToD.get(num));
                    updateState(i, j, state, num);
                }
            }
        }

    }

    private void updateState(int i, int j, int[][] state, int num) {
        int mask = ~num;
        for (int k = 0; k < state.length; k++) {
            state[k][j] &= mask;    // 按列消除
            state[i][k] &= mask;    // 按行消除
        }
        int m = i / 3, n = j / 3;   // 按块消除
        for (int a = m * 3; a <= m * 3 + 2; a++) {
            for (int b = n * 3; b <= n * 3 + 2; b++) {
                state[a][b] &= mask;
            }
        }
        state[i][j] = 0;
    }

    private boolean checkFinished(char[][] board) {
        for (char[] line : board)
            for (int j = 0; j < board.length; j++)
                if (line[j] == '.')
                    return false;
        return true;
    }

    private Map<Integer, Integer> initMap() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0b1, 1);
        map.put(0b10, 2);
        map.put(0b100, 3);
        map.put(0b1000, 4);
        map.put(0b10000, 5);
        map.put(0b100000, 6);
        map.put(0b1000000, 7);
        map.put(0b10000000, 8);
        map.put(0b100000000, 9);
        return map;
    }

    private int[][] checkFilled(char[][] board) {
        int[][] filledBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.')
                    filledBoard[i][j] = board[i][j] - '0';
            }
        }
        return filledBoard;
    }

    private int[][] initState(char[][] board, int[][] filledBoard, int[] decimalToB) {
        int[][] state = new int[board.length][board[0].length];

        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[0].length; j++) {
                if (board[i][j] == '.')
                    state[i][j] = 0b111111111;
            }
        }

        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[0].length; j++) {
                if (filledBoard[i][j] != 0) { //从 filledBoard中找到[i,j]对应元素，删除行，列，以及subBox中的
                    int num = filledBoard[i][j];
                    int mask = ~decimalToB[num]; // 按位取反，与对应数字做与运算，将对应位数置零
                    for (int k = 0; k < state.length; k++)   // 对行中所有元素的（右数）第num位置零
                        state[i][k] = state[i][k] & mask;

                    for (int k = 0; k < state.length; k++)   // 对列中所有元素的（右数）第num位置零
                        state[k][j] = state[k][j] & mask;

                    int m = i / 3, n = j / 3; //确定sub box的起终点
                    for (int a = m * 3; a <= m * 3 + 2; a++) {
                        for (int b = n * 3; b <= n * 3 + 2; b++) {
                            state[a][b] = state[a][b] & mask;
                        }
                    }
                }
            }
        }
        return state;
    }

    public static void main(String[] args) {
        SudokuSolver ss = new SudokuSolver();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},

                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '8', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},

                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        ss.solveSudoku(board);
        for (char[] line : board)
            System.out.println(Arrays.toString(line));
    }
}
