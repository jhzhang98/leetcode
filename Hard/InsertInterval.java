package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
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

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] all = new int[intervals.length + 1][2];
        System.arraycopy(intervals, 0, all, 0, intervals.length);
        all[all.length - 1] = newInterval;
        Arrays.sort(all, Comparator.comparingInt(o -> o[0]));

        return merge(all);
    }

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {9, 14};
        System.out.println(Arrays.deepToString(insertInterval.insert(intervals, newInterval)));
    }
}
