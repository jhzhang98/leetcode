package Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SellDiminishingValuedColoredBalls {
    public int maxProfitRight(int[] inventory, int orders) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        queue.add(0);
        for (int ballRemained : inventory)
            queue.add(ballRemained);
        long profit = 0;
        while (true) {
            int ball = queue.poll();
            if (ball > queue.peek()) {
                int canAdd = Math.min(ball - queue.peek(), orders);
                long head = ball, tail = ball - canAdd + 1;
                long tmp = ((head + tail) * canAdd / 2) % 1000000007;
                orders -= canAdd;
                ball -= canAdd;
                profit = (profit + tmp) % 1000000007;
                if (orders == 0)
                    return (int) profit;
                if (ball > 0)
                    queue.add(ball);
            } else {
                int count = 1;
                while (queue.peek() == ball) {
                    queue.poll();
                    count++;
                }
                while (true) {
                    int sellBalls = Math.min(count, orders);
                    profit = (profit + ((long) ball) * sellBalls) % 1000000007;
                    ball -= 1;
                    orders -= sellBalls;
                    if (orders == 0)
                        return (int) profit;
                    if (ball < queue.peek()) {
                        while (count-- > 0 && ball != 0)
                            queue.add(ball);
                        break;
                    }
                }
            }
        }
    }

    public int maxProfit(int[] inventory, int orders) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        queue.add(0);
        for (int ballRemained : inventory)
            queue.add(ballRemained);
        long profit = 0;
        while (true) {
            int ball = queue.poll();
            if (ball > queue.peek()) {
                int canAdd = Math.min(ball - queue.peek(), orders);
                long head = ball, tail = ball - canAdd + 1;
                long tmp = ((head + tail) * canAdd / 2) % 1000000007;
                orders -= canAdd;
                ball -= canAdd;
                profit = (profit + tmp) % 1000000007;
                if (orders == 0)
                    return (int) profit;
                if (ball > 0)
                    queue.add(ball);
            } else {
                int count = 1;
                while (queue.peek() == ball) {
                    queue.poll();
                    count++;
                }
                if (orders > count) {
                    int round = Math.min(orders / count, ball - queue.peek());
                    orders -= (round * count);
                    long start = ball, tail = ball - round + 1;
                    long tmp = (((start + tail)) * round / 2) % 1000000007 * count;
                    profit = (profit + tmp) % 1000000007;
                    ball -= round;
                    while (count-- > 0 && ball != 0)
                        queue.add(ball);
                } else {
                    int sellBalls = orders;
                    profit = (profit + ((long) ball) * sellBalls) % 1000000007;
                    ball -= 1;
                    orders -= sellBalls;
                    if (ball < queue.peek()) {
                        while (count-- > 0 && ball != 0)
                            queue.add(ball);
                    }
                }
                if (orders == 0)
                    return (int) profit;
            }
        }
    }

    public static void main(String[] args) {
        SellDiminishingValuedColoredBalls ball = new SellDiminishingValuedColoredBalls();
        int[] inventory = {1000000000, 1000000000, 1000000000-1};
        int orders = 1000000000;
        System.out.println(ball.maxProfit(inventory, orders));
    }
}
