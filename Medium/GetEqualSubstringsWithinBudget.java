package Medium;

import java.util.Arrays;

public class GetEqualSubstringsWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] cost = new int[s.length()];
        for (int i = 0; i < s.length(); i++)
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        int left = 0, right = 0;
        int curCost = cost[0];
        int maxLen = 0;
        while (left < s.length()) {
            if (curCost <= maxCost) {
                maxLen = Math.max(maxLen, right - left + 1);
                if (right == s.length() - 1)
                    break;
                right++;
                curCost += cost[right];
            } else {
                left++;
                curCost -= cost[left - 1];
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "zzc";
        int maxCost = 0;
        System.out.println(new GetEqualSubstringsWithinBudget().equalSubstring(s, t, maxCost));
    }
}
