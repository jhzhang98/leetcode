package Medium;

import java.util.Arrays;
import java.util.Comparator;

public class VideoStitching {
    /***
     * dp[i] = 剪到i秒所需要的最少步数
     * dp[clip[k][1]] = min(dp[clip[k][1]], dp[i] + 1) for each clip[k] && clip[k][0] <= i && clip[k][1] > i
     *
     */
    public int videoStitching(int[][] clips, int T) {
        if (!checkAvailable(clips, T))
            return -1;
        int[] dp = new int[T + 1];
        Arrays.fill(dp, Integer.MAX_VALUE >> 2);
        Arrays.sort(clips, Comparator.comparingInt(o -> o[0]));
        dp[0] = 0;
        for (int i = 0; i <= T; i++) {
            for (int[] clip : clips) {    // 当剪到第i秒时，挑选一个片段
                if (clip[0] > i)
                    break;
                if (clip[1] > i) {
                    for (int k = i + 1; k <= clip[1] && k <= T; k++)
                        dp[k] = Math.min(dp[k], dp[i] + 1);
                }
            }
        }
        if (dp[T] == Integer.MAX_VALUE >> 2)
            return -1;
        return dp[T];
    }

    /***
     * 如果开始不为零或者最大不为T，没必要做
     */
    private boolean checkAvailable(int[][] clips, int t) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int[] clip : clips) {
            min = Math.min(min, clip[0]);
            max = Math.max(max, clip[1]);
        }
        return min == 0 && max >= t;
    }

    public static void main(String[] args) {
        VideoStitching stitching = new VideoStitching();
        int[][] clips = {{0, 1}, {2, 5}};
//        int[][] clips = {{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
        System.out.println(stitching.videoStitching(clips, 5));
    }
}
