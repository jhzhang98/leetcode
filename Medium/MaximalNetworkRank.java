package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximalNetworkRank {
    private int secondDegree(int deletePoint, int n, int[][] roads){
        List<int[]> roadsUpdated = new ArrayList<>();
        for (int[] road : roads) {
            if (road[0] == deletePoint || road[1] == deletePoint) {
                continue;
            }
            roadsUpdated.add(road);
        }
        int[] degrees = new int[n];
        for (int[] road : roadsUpdated) {
            degrees[road[0]]++;
            degrees[road[1]]++;
        }
        int degreeB = Arrays.stream(degrees).max().getAsInt();
        return degreeB;
    }

    public int maximalNetworkRank(int n, int[][] roads) {
        if (n <= 1)
            return 0;
        int[] degrees = new int[n];
        for (int[] road : roads) {
            degrees[road[0]]++;
            degrees[road[1]]++;
        }
        int degreeA = 0;
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] > degreeA) {
                degreeA = degrees[i];
            }
        }
        // 把所有最大的度保存下来，挨个删除测试
        List<Integer> maxDegree = new ArrayList<>();
        for (int i=0 ; i<degrees.length ; i++){
            if (degrees[i] == degreeA)
                maxDegree.add(i);
        }
        int degreeB = 0;
        for (int p : maxDegree){
            degreeB = Math.max(secondDegree(p, n, roads), degreeB);
        }

        return degreeA + degreeB;
    }
}
