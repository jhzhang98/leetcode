package Medium;

import java.util.Arrays;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length())
            return false;
        int[] str1 = new int[26];
        for (char c : s1.toCharArray())
            str1[c - 'a']++;
        int[] window = new int[26];
        int left = 0, right = s1.length() - 1;
        for (int i = left; i <= right; i++)
            window[s2.charAt(i) - 'a']++;
        while (true) {
            if (Arrays.equals(window, str1))
                return true;
            if (right == s2.length() - 1)
                return false;
            window[s2.charAt(++right) - 'a']++;
            window[s2.charAt(left++) - 'a']--;
        }
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(new PermutationInString().checkInclusion(s1, s2));
    }
}
