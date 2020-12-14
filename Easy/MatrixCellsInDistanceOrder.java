package Easy;

import java.util.*;

public class MatrixCellsInDistanceOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++) {
                res.add(new int[]{i, j});
            }
        int[] center = {r0, c0};
        res.sort(Comparator.comparingInt(o -> manh(o, center)));
        int[][] array = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++)
            array[i] = res.get(i);
        return array;
    }

    private int manh(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new MatrixCellsInDistanceOrder().allCellsDistOrder(2, 3, 1, 2)));
    }
}
