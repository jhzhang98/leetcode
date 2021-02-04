package Medium;

import java.util.Arrays;

public class NumberOfIslands {
    private void dye(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        if (grid[x - 1][y] == '1')
            dye(grid, x - 1, y);
        if (grid[x + 1][y] == '1')
            dye(grid, x + 1, y);
        if (grid[x][y - 1] == '1')
            dye(grid, x, y - 1);
        if (grid[x][y + 1] == '1')
            dye(grid, x, y + 1);
    }

    public int numIslands(char[][] grid) {
        char[][] gridCp = new char[grid.length + 2][grid[0].length + 2];
        for (int i = 0; i < gridCp.length; i++)
            Arrays.fill(gridCp[i], '0');
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                gridCp[i + 1][j + 1] = grid[i][j];
            }
        }

        int island = 0;
        for (int i = 0; i < gridCp.length; i++) {
            for (int j = 0; j < gridCp[0].length; j++) {
                if (gridCp[i][j] == '1') {
                    dye(gridCp, i, j);
                    island++;
                }
            }
        }
        return island;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfIslands().numIslands(new char[][]{{'0'}}));
    }
}
