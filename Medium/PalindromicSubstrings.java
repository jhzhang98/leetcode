package Medium;

import java.util.Arrays;

public class PalindromicSubstrings {
    private int subStringsNum(int left, int right, char[] s) {
        int count = 0;
        while (left >= 0 && right < s.length) {
            if (s[left] == s[right])
                count++;
            else
                break;
            left--;
            right++;
        }
        return count;
    }

    public int countSubstrings(String s) {
        int[] res = new int[s.length()];
        char[] charSet = s.toCharArray();
        for (int center = 0; center < s.length(); center++) {
            int subCount = 1;
            int left = center - 1;
            int right = center + 1;
            subCount += subStringsNum(left, right, charSet);
            if (center + 1 < s.length() && charSet[center] == charSet[center + 1]) {
                subCount++;
                left = center - 1;
                right = center + 2;
                subCount += subStringsNum(left, right, charSet);
            }
            res[center] = subCount;
        }
        return Arrays.stream(res).sum();
    }

    public static void main(String[] args) {
        PalindromicSubstrings substrings = new PalindromicSubstrings();
        String s = "leetcode";
        System.out.println(substrings.countSubstrings(s));
    }
}
