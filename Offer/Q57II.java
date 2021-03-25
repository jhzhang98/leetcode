package Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q57II {
    private int[] getRes(int start, int end) {
        int[] res = new int[end - start + 1];
        for (int i = 0; i < res.length; i++)
            res[i] = start + i;
        return res;
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int left = 1, right = left + 1;
        while (right < target) {
            int sum = (left + right) * (right - left + 1) / 2;
            if (sum == target) {
                res.add(getRes(left, right));
                left++;
            } else if (sum < target) right++;
            else left++;
        }
        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++)
            result[i] = res.get(i);
        return result;
    }

    public static void main(String[] args) {
        int[][] res = new Q57II().findContinuousSequence(9);
        for (int[] re : res)
            System.out.println(Arrays.toString(re));
    }
}
