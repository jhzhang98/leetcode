package weekly.w221;

import java.util.Arrays;

public class Q3 {
    public int[] findBall(int[][] grid) {
        int[] pos = new int[2];
        int n = grid[0].length;
        int m = grid.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            pos[0] = 0;
            pos[1] = i;
            boolean contReach = false;
            while (pos[0] != m) {
                int x = pos[0];
                int y = pos[1];
                if (y == 0 && grid[x][y] == -1) {
                    contReach = true;
                    break;
                } else if (y == n - 1 && grid[x][y] == 1) {
                    contReach = true;
                    break;
                } else if (grid[x][y] == 1 && grid[x][y + 1] == -1) {
                    contReach = true;
                    break;
                } else if (grid[x][y] == -1 && grid[x][y - 1] == 1) {
                    contReach = true;
                    break;
                } else if (grid[x][y] == 1) {
                    pos[0] = x + 1;
                    pos[1] = y + 1;
                } else if (grid[x][y] == -1) {
                    pos[0] = x + 1;
                    pos[1] = y - 1;
                }
            }
            if (contReach)
                res[i] = -1;
            else
                res[i] = pos[1];
        }
        return res;
    }

    public static void main(String[] args) {
        Q3 q3 = new Q3();
        int[][] grid = {{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1}};
//        int[][] grid = {{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}};
//        int[][] grid = {{-1}};
        System.out.println(Arrays.toString(q3.findBall(grid)));
    }
}
