package Medium;

import java.util.Arrays;
import java.util.Comparator;

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, Comparator.comparingInt(o -> o[0]));
        int[][] res = new int[people.length][2];
        for (int i = 0; i < res.length; i++)
            res[i] = new int[]{-1, -1};

        for (int[] person : people) {
            int k = person[1];
            int h = person[0];
            int index = findKVacantPos(res, h, k);
            res[index] = person;
        }
        return res;
    }

    private int findKVacantPos(int[][] res, int h, int k) {
        int biggerNum = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i][0] >= h)
                biggerNum++;
            else if (res[i][0] == -1) {
                if (biggerNum == k)
                    return i;
                biggerNum++;
            }
        }
        return -1;
    }
}
