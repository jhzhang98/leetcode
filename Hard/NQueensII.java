package Hard;

import java.util.*;

public class NQueensII {
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

    public int totalNQueens(int n) {
        placeQueen(n, 0, new int[n][n]);
        return chessBoard.size();
    }

    public static void main(String[] args) {
        NQueensII queens = new NQueensII();
        System.out.println(queens.totalNQueens(4));
    }
}
