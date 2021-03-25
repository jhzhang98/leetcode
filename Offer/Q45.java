package Offer;

import java.util.Arrays;

public class Q45 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            strs[i] = "" + nums[i];
            maxLen = Math.max(maxLen, strs[i].length());
        }
        Arrays.sort(strs, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        String res = "";
        for (String str : strs)
            res += str;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(new Q45().minNumber(nums));
    }
}
