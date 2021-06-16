package Medium;

import tool.Union;

import java.util.*;

public class PathWithMinimumEffort {
    /**
     * 利用并查集，从最小的代价边开始添加，当添加边edge之后，发现起点和终点联通，结束
     * 由于是从最小代价边开始添加的，所以当前就是最小联通路径
     * 如何存储边信息？{sx, sy, tx, ty, cost}
     * 如何构造并查集？
     */
    public int minimumEffortPath2(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        if (m == n && n == 1)
            return 0;
        Union union = new Union(m * n);
//        UnionFind union = new UnionFind(m * n);
        List<int[]> edges = new ArrayList<>();
        // 注意，只需要添加该节点右边和下边就可以无重复地添加完整个图的边
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != m - 1)
                    edges.add(new int[]{i, j, i + 1, j, Math.abs(heights[i][j] - heights[i + 1][j])});
                if (j != n - 1)
                    edges.add(new int[]{i, j, i, j + 1, Math.abs(heights[i][j] - heights[i][j + 1])});
            }
        }
        edges.sort(Comparator.comparingInt(o -> o[4]));
        int res = Integer.MIN_VALUE;
        int src = 0, target = (m - 1) * n + n - 1;
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], nx = edge[2], ny = edge[3], cost = edge[4];
            union.merge(n * x + y, n * nx + ny);
            res = Math.max(res, cost);
            if (union.connected(src, target)) break;
        }
        return res;
    }

    /**
     * bfs + greedy
     * 广搜很很好理解，但是问题是如何存储之前走过的路径，否则将会出现死循环
     * 利用优先队列，对于每一个格子[x, y]而言，当前代价最小的永远会放到最前面，后面见到的代价都会大于等于之
     * 没有证明，所以这个感觉不严谨
     */
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        int[] cost = new int[m * n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = 0;
        boolean[] visited = new boolean[m * n];
        queue.add(new int[]{0, 0, 0});
        int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1], curCost = pos[2];
            if (visited[x * n + y])
                continue;
            visited[x * n + y] = true;
            for (int[] mv : move) {
                int nx = x + mv[0];
                int ny = y + mv[1];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                int nCost = Math.max(Math.abs(heights[x][y] - heights[nx][ny]), curCost);
                if (nCost <= cost[nx * n + ny]) {
                    cost[nx * n + ny] = nCost;
                    queue.add(new int[]{nx, ny, nCost});
                }
            }
        }
        return cost[m * n - 1];
    }

    public static void main(String[] args) {
        PathWithMinimumEffort effort = new PathWithMinimumEffort();
        int[][] heights = {{4, 3, 4, 10, 5, 5, 9, 2}, {10, 8, 2, 10, 9, 7, 5, 6}, {5, 8, 10, 10, 10, 7, 4, 2}, {5, 1, 3, 1, 1, 3, 1, 9}, {6, 4, 10, 6, 10, 9, 4, 6}};
//        int[][] heights = {{1, 10, 6, 7, 9, 10, 4, 9}};
//        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
//        int[][] heights = {{1, 2, 3}, {3, 8, 4}, {5, 3, 5}};
//        int[][] heights = {{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}};
        System.out.println(effort.minimumEffortPath(heights));
        System.out.println(effort.minimumEffortPath2(heights));
    }
}
