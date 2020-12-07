package Medium;

import java.util.*;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int max = Integer.MAX_VALUE >> 2;
        int[][] dp = new int[n][K + 2];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = max;

        Map<Integer, List<int[]>> edges = new HashMap<>();
        for (int[] flight : flights) {
            if (edges.containsKey(flight[0]))
                edges.get(flight[0]).add(new int[]{flight[1], flight[2]});
            else {
                List<int[]> lst = new LinkedList<>();
                lst.add(new int[]{flight[1], flight[2]});
                edges.put(flight[0], lst);
            }
        }
        dp[src][0] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            List<int[]> jointEdges = edges.get(cur);
            if (jointEdges == null || jointEdges.size() == 0)
                continue;
            for (int[] edge : jointEdges) {
                queue.add(edge[0]);
                for (int j = 0; j < dp[0].length; j++) {
                    if (dp[cur][j] != max && j + 1 < dp[0].length)
                        dp[edge[0]][j + 1] = Math.min(dp[edge[0]][j + 1], dp[cur][j] + edge[1]);
                }
            }
        }
        return dp[dst][K + 1] == max ? -1 : dp[dst][K + 1];
    }

    public static void main(String[] args) {
        CheapestFlightsWithinKStops stops = new CheapestFlightsWithinKStops();
        int n = 4;
        int[][] flights = {{0, 1, 50}, {0, 3, 150}, {0, 2, 100}, {1, 2, 100}, {1, 3, 100}, {3, 2, 50}};
        int src = 0;
        int dst = 2;
        int K = 0;
        System.out.println(stops.findCheapestPrice(n, flights, src, dst, K));
    }
}
