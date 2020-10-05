package Medium;

import java.util.*;

public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int a = n;
        n = m;
        m = a;
        int[][] dp = new int[m + 1][n + 1];
        int[] ones = new int[strs.length];
        int[] zeros = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int one = 0;
            int zero = 0;
            for (char c : str.toCharArray()) {
                if (c == '0')
                    zero++;
                else
                    one++;
            }
            ones[i] = one;
            zeros[i] = zero;
        }

        List<List<Set<Integer>>> strIndex = new ArrayList<>();
        for (int i = 0; i <= m; i++) {
            strIndex.add(new ArrayList<>());
            for (int j = 0; j <= n; j++) {
                strIndex.get(i).add(new HashSet<>());
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int maxNum = 0;
                int kIndex = -1;
                for (int k = 0; k < strs.length; k++) {
                    if (ones[k] <= i && zeros[k] <= j) {      // 可以判断找到上一个状态
                        int x = i - ones[k];
                        int y = j - zeros[k];
                        if (strIndex.get(x).get(y).contains(k))   // 如果上一个状态已经拿过这个字符串，next
                            continue;
                        int num = dp[x][y] + 1;
                        if (num > maxNum) {
                            maxNum = num;
                            kIndex = k;
                        }
                    }
                }
                if (kIndex != -1) {
                    dp[i][j] = maxNum;
                    strIndex.get(i).get(j).add(kIndex);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        OnesAndZeroes oz = new OnesAndZeroes();
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        System.out.println(oz.findMaxForm(strs, m, n));
    }
}
