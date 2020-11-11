package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FreedomTrail {
    /***
     * dp[i][j] = key的第i个字符，匹配到ring的第j个字符
     * pos[i] = key的第i个字符，再ring中的位置
     * 那么对于key的第i个字符中所有的位置pos in pos[dp.charAt(i)]
     * dp[i+1][j] = dp[i][pos] + min(向左轮转到j的步数，向右轮转到j的步数) + 1 （按按钮）
     * 对于第一个字符
     * dp[0][j] =  min(向左轮转到j的步数，向右轮转到j的步数) + 1 （按按钮）
     */
    public int findRotateSteps(String ring, String key) {
        int[][] dp = new int[key.length()][ring.length()];
        for (int[] line : dp) Arrays.fill(line, Integer.MAX_VALUE >> 3);
        List<List<Integer>> pos = new ArrayList<>();
        for (int i = 0; i < 26; i++)
            pos.add(new ArrayList<>());
        for (int i = 0; i < ring.length(); i++)
            pos.get(ring.charAt(i) - 'a').add(i);

        int len = ring.length();
        for (int p : pos.get(key.charAt(0) - 'a'))
            dp[0][p] = Math.min(p, len - p) + 1;    // 向左轮转，向右轮转中取最小，按下按钮

        for (int i = 1; i < key.length(); i++) {
            for (int p : pos.get(key.charAt(i) - 'a')) {
                for (int lastP : pos.get(key.charAt(i - 1) - 'a')) { // 从上次的字符到这次的字符所需要的move
                    dp[i][p] = Math.min(dp[i - 1][lastP] + Math.min(Math.abs(p - lastP), len - Math.abs(p - lastP)) + 1, dp[i][p]);
                }
            }
        }

        return Arrays.stream(dp[key.length() - 1]).min().getAsInt();
    }

    public static void main(String[] args) {
        FreedomTrail trail = new FreedomTrail();
        String ring = "bananaking", key = "akb";
        System.out.println(trail.findRotateSteps(ring, key));
    }
}
