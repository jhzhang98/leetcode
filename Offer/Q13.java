package Offer;

import java.util.LinkedList;
import java.util.Queue;

public class Q13 {
    public int movingCount(int m, int n, int k) {
        boolean[][] reach = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int res = 0;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            if (pos[0] < 0 || pos[1] < 0 || pos[0] >= m || pos[1] >= n)
                continue;
            if (reach[pos[0]][pos[1]])
                continue;
            else if (add(pos[0]) + add(pos[1]) > k)
                continue;
            reach[pos[0]][pos[1]] = true;
            res++;
            queue.add(new int[]{pos[0] - 1, pos[1]});
            queue.add(new int[]{pos[0] + 1, pos[1]});
            queue.add(new int[]{pos[0], pos[1] - 1});
            queue.add(new int[]{pos[0], pos[1] + 1});
        }

        return res;
    }

    private int add(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int m = 2, n = 3, k = 1;
        System.out.println(new Q13().movingCount(m, n, k));
    }
}
