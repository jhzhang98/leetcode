package Medium;

import java.util.Arrays;

public class RegionsCutBySlashes {
    public int regionsBySlashes(String[] grid) {
        int[][] island = buildIsland(grid);

        int isNum = 0;
        for (int i = 1; i < island.length; i++) {
            for (int j = 1; j < island[0].length; j++) {
                if (island[i][j] == 0) {
                    dye(island, i, j);
                    isNum++;
                }
            }
        }

        return isNum;
    }

    private void dye(int[][] island, int i, int j) {
        island[i][j] = 1;
        if (island[i - 1][j] == 0)
            dye(island, i - 1, j);
        if (island[i + 1][j] == 0)
            dye(island, i + 1, j);
        if (island[i][j - 1] == 0)
            dye(island, i, j - 1);
        if (island[i][j + 1] == 0)
            dye(island, i, j + 1);
    }

    private int[][] buildIsland(String[] grid) {
        int len = grid.length * 3;
        int[][] res = new int[len + 2][len + 2];
        for (int i = 0; i < res.length; i++)
            Arrays.fill(res[i], 0);
        for (int i = 0; i < res.length; i++) {
            res[i][0] = 1;
            res[i][res[0].length - 1] = 1;
        }
        for (int j = 0; j < res[0].length; j++) {
            res[0][j] = 1;
            res[res.length - 1][j] = 1;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                char c = grid[i].charAt(j);
                if (c == '\\') {
                    res[i * 3 + 1][j * 3 + 1] = 1;
                    res[i * 3 + 2][j * 3 + 2] = 1;
                    res[i * 3 + 3][j * 3 + 3] = 1;
                } else if (c == '/'){
                    res[i * 3 + 3][j * 3 + 1] = 1;
                    res[i * 3 + 2][j * 3 + 2] = 1;
                    res[i * 3 + 1][j * 3 + 3] = 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] grid = {"/\\", "\\/"};
        System.out.println(new RegionsCutBySlashes().regionsBySlashes(grid));
    }
}
