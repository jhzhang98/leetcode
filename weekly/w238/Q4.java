package weekly.w238;

import java.util.Arrays;
import java.util.Comparator;

public class Q4 {
    public int maxBuilding(int n, int[][] restrictions) {
        int[][] rests = new int[restrictions.length + 1][2];
        rests[0] = new int[]{1, 0};
        System.arraycopy(restrictions, 0, rests, 1, restrictions.length);
        Arrays.sort(rests, Comparator.comparingInt(o -> o[0]));
        int curH = 0;
        int preIndex = 1;
        for (int i = 1; i < rests.length; i++) {
            int[] rest = rests[i];
            int tmpH = curH + rest[0] - preIndex;
            tmpH = Math.min(tmpH, rest[1]);
            rest[1] = tmpH;
            curH = tmpH;
            preIndex = rest[0];
        }
        curH = rests[rests.length - 1][1];
        preIndex = rests[rests.length - 1][0];
        for (int i = rests.length - 1; i > 0; i--) {
            int[] rest = rests[i];
            int tmpH = curH + Math.abs(rest[0] - preIndex);
            tmpH = Math.min(tmpH, rest[1]);
            rest[1] = tmpH;
            curH = tmpH;
            preIndex = rest[0];
        }

        int maxH = 0;
        for (int i = 1; i < rests.length; i++) {
            int[] pre = rests[i - 1];
            int[] cur = rests[i];
            int M = pre[1], N = cur[1];
            int I = pre[0], J = cur[0];
            int a = (N - M + J - I ) / 2;
            int b = a - (N - M);
            int midH = Math.max(M + a, N + b);
            int locMax = Math.max(pre[1], cur[1]);
            locMax = Math.max(locMax, midH);
            maxH = Math.max(maxH, locMax);
        }

        int tailH = rests[rests.length - 1][1] + n - rests[rests.length - 1][0];
        return Math.max(maxH, tailH);
    }

    public static void main(String[] args) {
        int n = 10;
        int[][] rests = {{5, 3}, {2, 5}, {7, 4}, {10, 3}};
        System.out.println(new Q4().maxBuilding(n, rests));
    }
}
