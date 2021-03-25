package Hard;

public class UniquePathsIII {
    int m, n;
    int[] srcPos;
    int[] tarPos;
    int res = 0;
    int[][] grid;
    private int[] moveX = {1, -1, 0, 0};
    private int[] moveY = {0, 0, 1, -1};

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int allowedMove = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    srcPos = new int[]{i, j};
                else if (grid[i][j] == 2)
                    tarPos = new int[]{i, j};
                else if (grid[i][j] == 0)
                    allowedMove++;
            }
        }
        dfs(srcPos[0], srcPos[1], allowedMove);
        return res;
    }

    private void dfs(int srcX, int srcY, int allowedMove) {
        if (allowedMove == 0 && srcX == tarPos[0] && srcY == tarPos[1]) {
            res++;
            return;
        }
        for (int i = 0; i < moveX.length; i++) {
            int nextX = srcX + moveX[i];
            int nextY = srcY + moveY[i];
            if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n)
                continue;
            if (grid[nextX][nextY] != 0 && grid[nextX][nextY] != 2)
                continue;
            grid[nextX][nextY] = -1;
            dfs(nextX, nextY, allowedMove - 1);
            grid[nextX][nextY] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0}, {0, 0, 0}, {0, 0, 2}};
        System.out.println(new UniquePathsIII().uniquePathsIII(grid));
    }
}
