package biweekly.w47;

import java.util.ArrayList;
import java.util.List;

public class Q1 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        List<int[]> lst = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] != x && point[1] != y)
                continue;
            int dis = Math.abs(x - point[0]) + Math.abs(y - point[1]);
            lst.add(new int[]{dis, i});
        }
        if (lst.size() == 0)
            return -1;
        lst.sort((o1, o2) -> {
            if (o1[0] < o2[0])
                return -1;
            else if (o1[0] > o2[0])
                return 1;
            else
                return Integer.compare(o1[1], o2[1]);
        });
        return lst.get(0)[1];
    }
}
