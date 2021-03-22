package weekly.w233;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q2 {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buyOrders = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0], o1[0]));
        PriorityQueue<int[]> sellOrders = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        buyOrders.add(new int[]{Integer.MIN_VALUE, 0, 0});
        sellOrders.add(new int[]{Integer.MAX_VALUE, 0, 0});

        for (int[] order : orders) {
            if (order[2] == 0) {
                if (order[0] >= sellOrders.peek()[0]) {
                    while (order[1] > sellOrders.peek()[1] && order[0] >= sellOrders.peek()[0]) {
                        order[1] -= sellOrders.poll()[1];
                    }
                    if (order[0] >= sellOrders.peek()[0]) {
                        if (order[1] < sellOrders.peek()[1]) {
                            sellOrders.peek()[1] -= order[1];
                        } else {
                            sellOrders.poll();
                        }
                        order[1] = 0;
                    }
                    if (order[1] != 0)
                        buyOrders.add(order);
                } else {
                    buyOrders.add(order);
                }
            } else {
                if (order[0] <= buyOrders.peek()[0]) {
                    while (order[1] > buyOrders.peek()[1] && order[0] <= buyOrders.peek()[0]) {
                        order[1] -= buyOrders.poll()[1];
                    }
                    if (order[0] <= buyOrders.peek()[0]) {
                        if (order[1] < buyOrders.peek()[1]) {
                            buyOrders.peek()[1] -= order[1];
                        } else {
                            buyOrders.poll();
                        }
                        order[1] = 0;
                    }
                    if (order[1] != 0)
                        sellOrders.add(order);
                } else {
                    sellOrders.add(order);
                }
            }
        }

        long res = 0, mask = 1000000007;
        while (!buyOrders.isEmpty()) res = (res + buyOrders.poll()[1]) % mask;
        while (!sellOrders.isEmpty()) res = (res + sellOrders.poll()[1]) % mask;
        return (int) res;
    }

    public static void main(String[] args) {
        int[][] orders = {{10, 5, 0}, {15, 2, 1}, {25, 1, 1}, {30, 4, 0}};
        System.out.println(new Q2().getNumberOfBacklogOrders(orders));
    }
}
