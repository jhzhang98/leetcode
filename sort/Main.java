package sort;

import java.util.*;

public class Main {
    public int[] getRes(int N, int L) {
        if (2 * N < (L - 1) * L)
            return null;
        int len = L;
        int start = -1;
        while (true) {
            if (len > 100) return null;
            start = 2 * N / len;
            if (start * len != 2 * N) {
                len++;
                continue;
            }
            start = start - len + 1;
            if (start < 0) return null;
            else if (start % 2 != 0)
                len++;
            else {
                start = start >> 1;
                break;
            }
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++)
            res[i] = i + start;
        return res;
    }

    private static void readAndTest() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String line = in.nextLine();
            String[] strs = line.split(" ");
            int[] input = new int[2];
            for (int i = 0; i < strs.length; i++)
                input[i] = Integer.parseInt(strs[i]);
            int[] res = new Main().getRes(input[0], input[1]);
            if (res == null) {
                System.out.println("No");
                continue;
            }
            StringBuilder str = new StringBuilder();
            for (int num : res)
                str.append(num).append(" ");
            System.out.println(str.substring(0, str.length() - 1));
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 7, 4};
    }
}
