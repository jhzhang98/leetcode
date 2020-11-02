package Medium;

import java.util.*;

public class FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        Queue<Integer> pastGap = new PriorityQueue<>(Comparator.comparingInt(o -> -o));
        int[] gaps = new int[heights.length];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[i - 1])
                gaps[i] = heights[i] - heights[i - 1];
        }
        int dis = 0;
        for (; dis < gaps.length; dis++) {
            if (gaps[dis] == 0)
                continue;
            if (gaps[dis] <= bricks) {
                pastGap.add(gaps[dis]);
                bricks -= gaps[dis];
            } else
                break;
        }
        dis -= 1;

        while (ladders-- > 0) {
            int maxGap = 0;
            if (!pastGap.isEmpty()) pastGap.poll();

            int nextGap = -1;
            int nextGapIndex = -1;
            for (int i = dis + 1; i < heights.length; i++)
                if (gaps[i] != 0) {
                    nextGap = gaps[i];
                    nextGapIndex = i;
                    break;
                }
            if (nextGap > maxGap) {     // 下一个最高，那么梯子放在这，bricks不变
                dis = nextGapIndex;
            } else {
                bricks += maxGap;       // 如果不是，梯子放在之前最高处，bricks增加
            }

            for (dis = dis + 1; dis < heights.length; dis++) {   // 向后接着走
                if (gaps[dis] == 0)
                    continue;
                if (gaps[dis] <= bricks) {
                    pastGap.add(gaps[dis]);
                    bricks -= gaps[dis];
                } else
                    break;
            }
            dis -= 1;
        }

        return dis;
    }

    public static void main(String[] args) {
        FurthestBuildingYouCanReach reach = new FurthestBuildingYouCanReach();
        int[] heights = {1, 13, 1, 1, 13, 5, 11, 11};
        int bricks = 10, ladder = 8;
        System.out.println(reach.furthestBuilding(heights, bricks, ladder));
    }
}
