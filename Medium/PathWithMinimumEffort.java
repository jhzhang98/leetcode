package Medium;

import java.util.*;

public class PathWithMinimumEffort {
    class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return x == pos.x &&
                    y == pos.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    int minCost = Integer.MAX_VALUE >> 2;

    /***
     * 暴力搜索失败，路径情况太多，直接爆炸，无法运行结束
     */
    public int minimumEffortPath(int[][] heights) {
        List<Pos> path = new LinkedList<>();
        path.add(new Pos(0, 0));
        dfs(heights, 0, 0, 0, path);
        return minCost;
    }

    private void dfs(int[][] heights, int i, int j, int cost, List<Pos> path) {
        if (i == heights.length - 1 && j == heights[0].length - 1) {
            minCost = Math.min(cost, minCost);
        } else {
            if (i > 0 && !path.contains(new Pos(i - 1, j))) {
                List<Pos> cp = new LinkedList<>(path);
                cp.add(new Pos(i - 1, j));
                dfs(heights, i - 1, j, Math.max(cost, Math.abs(heights[i][j] - heights[i - 1][j])), cp);
            }
            if (j > 0 && !path.contains(new Pos(i, j - 1))) {
                List<Pos> cp = new LinkedList<>(path);
                cp.add(new Pos(i, j - 1));
                dfs(heights, i, j - 1, Math.max(cost, Math.abs(heights[i][j] - heights[i][j - 1])), cp);
            }
            if (i < heights.length - 1 && !path.contains(new Pos(i + 1, j))) {
                List<Pos> cp = new LinkedList<>(path);
                cp.add(new Pos(i + 1, j));
                dfs(heights, i + 1, j, Math.max(cost, Math.abs(heights[i][j] - heights[i + 1][j])), cp);
            }
            if (j < heights[0].length - 1 && !path.contains(new Pos(i, j + 1))) {
                List<Pos> cp = new LinkedList<>(path);
                cp.add(new Pos(i, j + 1));
                dfs(heights, i, j + 1, Math.max(cost, Math.abs(heights[i][j] - heights[i][j + 1])), cp);
            }
        }
    }

    /***
     * dp[i][j] 是从0，0到i，j的最小代价
     * if dp[i+1][j] 没有过值
     *      dp[i+1][j] = Math.max(max(abs(dp[i][j] - dp[i+1][j]), dp[i][j]), dp[i+1][j])
     * else
     *      dp[i+1][j] = Math.min(max(abs(dp[i][j] - dp[i+1][j]), dp[i][j]), dp[i+1][j])
     * 为了统一符号，直接将dp默认为最大值，这样就无论如何取最小
     * 差和自己的代价中取大，然后和dp[i+1][j]取小
     * 算法不对，先更新的点有可能是路径最后走到的，就无法再度更新
     */
    public int minimumEffortPathDp(int[][] heights) {
        int[][] dp = new int[heights.length][heights[0].length];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = Integer.MAX_VALUE >> 2;
        dp[0][0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i < dp.length - 1)
                    dp[i + 1][j] = Math.min(Math.max(Math.abs(heights[i + 1][j] - heights[i][j]), dp[i][j]), dp[i + 1][j]);
                if (j < dp[0].length - 1)
                    dp[i][j + 1] = Math.min(Math.max(dp[i][j], Math.abs(heights[i][j + 1] - heights[i][j])), dp[i][j + 1]);
                if (i > 0)
                    dp[i - 1][j] = Math.min(Math.max(dp[i][j], Math.abs(heights[i - 1][j] - heights[i][j])), dp[i - 1][j]);
                if (j > 0)
                    dp[i][j - 1] = Math.min(Math.max(dp[i][j], Math.abs(heights[i][j - 1] - heights[i][j])), dp[i][j - 1]);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        PathWithMinimumEffort effort = new PathWithMinimumEffort();
        int[][] heights = {{4, 3, 4, 10, 5, 5, 9, 2}, {10, 8, 2, 10, 9, 7, 5, 6}, {5, 8, 10, 10, 10, 7, 4, 2}, {5, 1, 3, 1, 1, 3, 1, 9}, {6, 4, 10, 6, 10, 9, 4, 6}};
//        int[][] heights = {{1, 10, 6, 7, 9, 10, 4, 9}};
//        int[][] heights = {{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}};
        System.out.println(effort.minimumEffortPath(heights));
    }
}
