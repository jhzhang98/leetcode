package Offer;

import java.util.HashSet;
import java.util.Set;

public class Q48 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seek = new HashSet<>();
        int left = 0, right = 0;
        int maxLen = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (seek.contains(c)) {
                do {
                    seek.remove(s.charAt(left));
                    left++;
                } while (seek.contains(c));
            }
            seek.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "bbbb";
        System.out.println(new Q48().lengthOfLongestSubstring(s));
    }
}
