package Easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortArrayByIncreasingFrequency {
    class Point {
        int num;
        int fre;

        public Point(int num, int fre) {
            this.num = num;
            this.fre = fre;
        }
    }

    public int[] frequencySort(int[] nums) {
        int[] numsRange = new int[220];
        for (int num : nums) numsRange[num + 100]++;

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < numsRange.length; i++) {
            if (numsRange[i] != 0) {
                int count = numsRange[i];
                while (count-- != 0) {
                    points.add(new Point(i - 100, numsRange[i]));
                }
            }
        }
        points.sort((o1, o2) -> {
            if (o1.fre < o2.fre)
                return -1;
            else if (o1.fre > o2.fre)
                return 1;
            else
                return Integer.compare(o2.num, o1.num);
        });
        int[] res = new int[points.size()];
        for (int i = 0; i < points.size(); i++)
            res[i] = points.get(i).num;
        return res;
    }
}
