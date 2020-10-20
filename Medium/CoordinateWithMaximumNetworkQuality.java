package Medium;

import java.util.Arrays;

public class CoordinateWithMaximumNetworkQuality {
    private float euDis(int[] p1, int[] p2) {
        float dis = 0;
        dis = (float) Math.sqrt((p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]));
        return dis;
    }

    public int[] bestCoordinate(int[][] towers, int radius) {
        float[][] dis = new float[towers.length][towers.length];
        for (int i = 0; i < dis.length; i++) {
            for (int j = i + 1; j < dis.length; j++) {
                dis[i][j] = euDis(towers[i], towers[j]);
                dis[j][i] = dis[i][j];
            }
        }

        int maxPower = Integer.MIN_VALUE;
        int x = -1, y = -1;
        for (int i = 0; i < dis.length; i++) {
            int power = 0;
            for (int j = 0; j < dis.length; j++) {
                if (dis[j][i] <= radius) {
                    power += (int) (towers[j][2] * 1.0 / (1 + dis[j][i]));
                }
            }
            if (power > maxPower) {
                x = towers[i][0];
                y = towers[i][1];
                maxPower = power;
            }
            if (power == maxPower) {
                if (towers[i][0] < x) {
                    x = towers[i][0];
                    y = towers[i][1];
                }else if (towers[i][0] == x && towers[i][1] < y){
                    x = towers[i][0];
                    y = towers[i][1];
                }
            }
        }

        return new int[]{x, y};
    }

    public static void main(String[] args) {
        CoordinateWithMaximumNetworkQuality quality = new CoordinateWithMaximumNetworkQuality();
        int[][] towers = {{1, 2, 5}, {2, 1, 7}, {3, 1, 9}};
        int rad = 2;
        System.out.println(Arrays.toString(quality.bestCoordinate(towers, rad)));
    }
}
