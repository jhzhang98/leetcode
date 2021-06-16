package Hard;

import java.util.*;

public class SudokuSolver {
    char[] solution = null;

    public void solveSudoku(char[][] board) {
        List<Set<Character>> colSet = new ArrayList<>();
        List<Set<Character>> rowSet = new ArrayList<>();
        List<Set<Character>> gongSet = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            colSet.add(new HashSet<>());
            rowSet.add(new HashSet<>());
            gongSet.add(new HashSet<>());
        }

        char[] newBoard = new char[81];
        List<int[]> remained = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                newBoard[i * 9 + j] = board[i][j];
                if (board[i][j] != '.') {
                    colSet.get(j).add(board[i][j]);
                    rowSet.get(i).add(board[i][j]);
                    gongSet.get((i / 3) * 3 + j / 3).add(board[i][j]);
                } else {
                    remained.add(new int[]{i, j});
                }
            }
        }

        dfs(newBoard, colSet, rowSet, gongSet, remained, 0);

        for (int i = 0; i < solution.length; i++) {
            board[i / 9][i % 9] = solution[i];
        }
    }

    private void dfs(char[] board, List<Set<Character>> colSet, List<Set<Character>> rowSet, List<Set<Character>> gongSet, List<int[]> remained, int index) {
        if (this.solution != null) return;
        if (index >= remained.size()) {
            this.solution = Arrays.copyOf(board, board.length);
            return;
        }

        int[] pos = remained.get(index);
        int x = pos[0], y = pos[1];
        for (int j = 1; j <= 9; j++) {
            char val = (char) ('0' + j);
            if (rowSet.get(x).contains(val)) continue;
            if (colSet.get(y).contains(val)) continue;
            if (gongSet.get((x / 3) * 3 + y / 3).contains(val)) continue;

            board[x * 9 + y] = val;

            rowSet.get(x).add(val);
            colSet.get(y).add(val);
            gongSet.get((x / 3) * 3 + y / 3).add(val);

            dfs(board, colSet, rowSet, gongSet, remained, index + 1);

            gongSet.get((x / 3) * 3 + y / 3).remove(val);
            colSet.get(y).remove(val);
            rowSet.get(x).remove(val);

            board[x * 9 + y] = '.';
        }
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
