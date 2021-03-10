package Medium;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        char[] getMask = new char[10];
        char mask = 1;
        getMask[0] = mask;
        for (int i = 1; i < 10; i += 1) {
            mask <<= 1;
            getMask[i] = mask;
        }
        // 按行检查
        for (char[] chars : board) {
            int row = 0;
            for (int j = 0; j < board[0].length; j++) {
                if (chars[j] == '.')
                    continue;
                mask = getMask[chars[j] - '0'];
                if ((mask & row) > 0)
                    return false;
                row = row | mask;
            }
        }
        // 按列检查
        for (int j = 0; j < board[0].length; j++) {
            int col = 0;
            for (char[] chars : board) {
                if (chars[j] == '.')
                    continue;
                mask = getMask[chars[j] - '0'];
                if ((mask & col) > 0)
                    return false;
                col = col | mask;
            }
        }


        // 按宫检查
        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {
                int check = 0;
                for (int i = 3 * m; i < 3 * m + 3; i++) {
                    for (int j = 3 * n; j < 3 * n + 3; j++) {
                        if (board[i][j] == '.')
                            continue;
                        mask = getMask[board[i][j] - '0'];
                        if ((mask & check) > 0)
                            return false;
                        check = check | mask;
                    }
                }
            }
        }
        return true;
    }

}
