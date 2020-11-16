package Medium;

import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0)
            return intervals;
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[] interval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (interval[1] < next[0]) {
                res.add(interval);
                interval = next;
                continue;
            }
            interval[0] = Math.min(interval[0], next[0]);
            interval[1] = Math.max(interval[1], next[1]);
        }
        res.add(interval);

        int[][] resIntervals = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++)
            resIntervals[i] = res.get(i);
        return resIntervals;
    }

}
