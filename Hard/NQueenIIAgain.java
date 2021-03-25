package Hard;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class NQueenIIAgain {
    int res = 0;
    int n;

    private void place(int i, Set<Integer> placedCol, Set<Integer> placedDiag1, Set<Integer> placedDiag2) {
        if (i == n) {
            res++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (placedCol.contains(j)) continue;
            if (placedDiag1.contains(i - j)) continue;
            if (placedDiag2.contains(i + j)) continue;
            placedCol.add(j);
            placedDiag1.add(i - j);
            placedDiag2.add(i + j);
            place(i + 1, placedCol, placedDiag1, placedDiag2);
            placedCol.remove(j);
            placedDiag1.remove(i - j);
            placedDiag2.remove(i + j);
        }
    }

    public int totalNQueens(int n) {
        this.n = n;
        place(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(new NQueenIIAgain().totalNQueens(n));
    }
}
