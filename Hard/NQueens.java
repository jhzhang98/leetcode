package Hard;

import java.util.*;

/***
 * 可以不需要棋盘，只需要存放后的位置，(i, j)坐标，
 * 然后每次判断能否被攻击到，省去复制棋盘的时间，但是懒得改了
 */
public class NQueens {
    class Board {
        int[][] board;

        public Board(int[][] board) {
            this.board = board;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Board other = (Board) o;
            for (int i = 0; i < board.length; i++) {
                if (!Arrays.equals(this.board[i], other.board[i]))
                    return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(board);
        }
    }

    Set<Board> chessBoard = new HashSet<>();

    private int[][] copyBoard(int[][] board) {
        int[][] cp = new int[board.length][board.length];
        for (int i = 0; i < cp.length; i++)
            System.arraycopy(board[i], 0, cp[i], 0, cp.length);
        return cp;
    }

    private void placeQueen(int n, int queensNum, int[][] board) {
        if (queensNum == n) {
            Board b = new Board(board);
            chessBoard.add(b);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (board[queensNum][i] == -1)
                continue;
            int[][] newBoard = updateBoard(queensNum, i, board);
            placeQueen(n, queensNum + 1, newBoard);
        }
    }

    private int[][] updateBoard(int row, int col, int[][] board) {
        int[][] boardCp = copyBoard(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (i == row || j == col || (i + j == row + col) || (j - i == col - row))
                    boardCp[i][j] = -1;
            }
        }
        boardCp[row][col] = 1;
        return boardCp;
    }

    private boolean notSatisfied(int row, int col, int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (i == row || j == col || (i + j == row + col) || (j - i == col - row)) {
                    if (board[i][j] == 1)   // 攻击范围上有棋子
                        return true;
                }
            }
        }
        return false;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        placeQueen(n, 0, new int[n][n]);
        for (Board b : chessBoard) {
            int[][] board = b.board;
            List<String> place = new ArrayList<>();
            for (int[] ints : board) {
                StringBuilder line = new StringBuilder();
                for (int j = 0; j < board.length; j++) {
                    if (ints[j] == 1)
                        line.append('Q');
                    else
                        line.append('.');
                }
                place.add(String.valueOf(line));
            }
            res.add(place);
        }
        return res;
    }

    public static void main(String[] args) {
        NQueens queens = new NQueens();
        int n = 8;
        List<List<String>> res = queens.solveNQueens(n);
        for (List<String> board : res) {
            System.out.println(board);
        }
    }
}
