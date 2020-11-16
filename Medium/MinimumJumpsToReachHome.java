package Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumJumpsToReachHome {
    int minimum = Integer.MAX_VALUE;
    boolean[] forbidden = new boolean[4000];
    boolean[][] seek = new boolean[2][4000];
    int a, b;
    int dest;

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Arrays.fill(this.forbidden, false);
        Arrays.fill(this.seek[0], false);
        Arrays.fill(this.seek[1], false);
        for (int j : forbidden) this.forbidden[j] = true;
        this.a = a;
        this.b = b;
        this.dest = x;
        jump(0, false, 0);
        return minimum == Integer.MAX_VALUE ? -1 : minimum;
    }

    private void jump(int pos, boolean back, int jumCount) {
        if (pos == dest)
            minimum = Math.min(minimum, jumCount);
        if (back) {
            int nextPos = pos + a;
            if (forbidden[nextPos])
                return;
            if (nextPos <= dest + b && !seek[0][nextPos]) {
                seek[0][nextPos] = true;
                jump(nextPos, false, jumCount + 1);
                seek[0][nextPos] = false;
            }
        } else {
            int forward = pos + a;
            int backward = pos - b;
            if (forward <= dest + b && !seek[1][forward] && !forbidden[forward]) {
                seek[1][forward] = true;
                jump(forward, false, jumCount + 1);
                seek[1][forward] = false;
            }
            if (backward > 0 && !seek[1][backward] && !forbidden[backward]) {
                seek[1][backward] = true;
                jump(backward, true, jumCount + 1);
                seek[1][backward] = false;
            }
        }
    }

    public static void main(String[] args) {
        MinimumJumpsToReachHome home = new MinimumJumpsToReachHome();
        int[] forbidden = {162, 118, 178, 152, 167, 100, 40, 74, 199, 186, 26, 73, 200, 127, 30, 124, 193, 84, 184, 36, 103, 149, 153, 9, 54, 154, 133, 95, 45, 198, 79, 157, 64, 122, 59, 71, 48, 177, 82, 35, 14, 176, 16, 108, 111, 6, 168, 31, 134, 164, 136, 72, 98};
        int a = 29, b = 98;
        int x = 80;
        System.out.println(home.minimumJumps(forbidden, a, b, x));
    }
}
