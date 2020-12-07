package Medium;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int pos = points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] > pos){
                count++;
                pos = point[1];
            }
        }
        return count;
    }
}
