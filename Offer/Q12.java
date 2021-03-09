package Offer;

public class Q12 {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0)
            return false;
        char[] charset = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean flag = dfs(board, i, j, charset, 0);
                if (flag)
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] charset, int charIndex) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        if (board[i][j] != charset[charIndex])
            return false;
        if (charIndex == charset.length - 1)
            return true;

        board[i][j] = ' ';
        boolean res =
                dfs(board, i - 1, j, charset, charIndex + 1) ||
                        dfs(board, i + 1, j, charset, charIndex + 1) ||
                        dfs(board, i, j - 1, charset, charIndex + 1) ||
                        dfs(board, i, j + 1, charset, charIndex + 1);
        board[i][j] = charset[charIndex];
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCESEEEFS";
        System.out.println(new Q12().exist(board, word));
    }

}
