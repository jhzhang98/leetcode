package Medium;

import java.util.*;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Queue<Integer> nodes = new LinkedList<>();
        nodes.add(src);
        // 初始化邻接表，edges.get(i)存储所有邻接flights的index
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++)
            edges.add(new ArrayList<>());
        for (int i = 0; i < flights.length; i++) {
            int[] flight = flights[i];
            edges.get(flight[0]).add(i);
        }
        // key -> point, value -> 从src到point的中转数为 value.key 的最小代价
        Map<Integer, Map<Integer, Integer>> pointCost = new HashMap<>();
        Map<Integer, Integer> srcCost = new HashMap<>();
        srcCost.put(-1, 0);
        pointCost.put(src, srcCost);
        while (!nodes.isEmpty()) {
            int node = nodes.poll();
            List<Integer> indexes = edges.get(node);
            Map<Integer, Integer> lastCost = pointCost.get(node);
            for (int index : indexes) {   // 对于node的所有邻接边，遍历更新
                int[] flight = flights[index];
                nodes.add(flight[1]);
                if (pointCost.containsKey(flight[1])) {  // 如果当前有节点flight[1]，说明从其他的节点路过过
                    for (int key : lastCost.keySet()) {
                        int cost = lastCost.get(key) + flight[2];
                        if (pointCost.get(flight[1]).containsKey(key + 1)) {  // 如果中转数相同，维护一个最小的
                            if (cost < pointCost.get(flight[1]).get(key + 1)) {
                                pointCost.get(flight[1]).put(key + 1, cost);
                            }
                        } else {
                            pointCost.get(flight[1]).put(key + 1, cost);
                        }
                    }
                } else {  // 如果没有，直接更新，中转数+1，cost+flight[2]
                    Map<Integer, Integer> cost = new HashMap<>();
                    for (int key : lastCost.keySet()) {
                        cost.put(key + 1, lastCost.get(key) + flight[2]);
                    }
                    pointCost.put(flight[1], cost);
                }
            }
        }
        return pointCost.get(dst).get(K);
    }

    public static void main(String[] args) {
        CheapestFlightsWithinKStops stops = new CheapestFlightsWithinKStops();
        int n = 3;
        int[][] flights = {{0, 1, 100},{1, 2, 100},{0, 2, 500}};
        int src = 0;
        int dst = 2;
        int K = 0;
        System.out.println(stops.findCheapestPrice(n, flights, src, dst, K));
    }
}
