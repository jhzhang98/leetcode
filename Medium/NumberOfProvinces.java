package Medium;

import java.util.*;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited.contains(i))
                continue;
            queue.add(i);
            count++;
            while (!queue.isEmpty()) {
                int next = queue.poll();
                for (int j = 0; j < isConnected[0].length; j++) {
                    if (isConnected[next][j] == 1 && !visited.contains(j)) {
                        visited.add(j);
                        queue.add(j);
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] isConnected = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        System.out.println(new NumberOfProvinces().findCircleNum(isConnected));
    }
}
