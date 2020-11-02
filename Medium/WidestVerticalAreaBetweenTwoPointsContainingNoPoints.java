package Medium;

import java.util.Arrays;

public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] x = new int[points.length];
        for (int i = 0; i < points.length; i++)
            x[i] = points[i][0];

        Arrays.sort(x);
        int dis = x[1] - x[0];
        for (int i = 2; i < x.length; i++)
            dis = Math.max(dis, x[i] - x[i - 1]);
        return dis;
    }
}
