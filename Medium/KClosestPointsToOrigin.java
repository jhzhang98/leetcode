package Medium;

import java.util.Arrays;

public class KClosestPointsToOrigin {
    private int dis(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (o1, o2) -> Integer.compare(dis(o1), dis(o2)));
        int[][] res = new int[K][2];
        System.arraycopy(points, 0, res, 0, K);
        return res;
    }

    public static void main(String[] args) {
        
    }
}
