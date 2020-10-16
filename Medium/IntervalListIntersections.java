package Medium;

import java.util.LinkedList;
import java.util.List;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new LinkedList<>();

        int AIndex = 0, BIndex = 0;
        while (AIndex < A.length && BIndex < B.length) {
            int[] a = A[AIndex];
            int[] b = B[BIndex];

            int left = Math.max(a[0], b[0]);
            int right = Math.min(a[1], b[1]);
            if(left <= right)
                res.add(new int[]{left, right});

            if(a[1] < b[1])
                AIndex++;
            else
                BIndex++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
