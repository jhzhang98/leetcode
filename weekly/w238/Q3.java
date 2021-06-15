package weekly.w238;

import java.util.HashSet;
import java.util.Set;

public class Q3 {
    private int findA(String word, int index) {
        for (int i = index; i < word.length(); i++) {
            if (word.charAt(i) == 'a')
                return i;
        }
        return -1;
    }

    public int longestBeautifulSubstring(String word) {
        int left = findA(word, 0);
        if (left < 0) return 0;
        int right = left + 1;
        char[] charArray = {'a', 'e', 'i', 'o', 'u', '#'};
        int curChar = 0;
        int maxLen = -1;
        int visited = 1;

        while (right < word.length()) {
            char c = word.charAt(right);
            if (c == charArray[curChar + 1]) {
                curChar++;
                visited++;
            } else if (c != charArray[curChar]) {
                left = findA(word, right);
                if (left == -1)
                    break;
                curChar = 0;
                right = left + 1;
                visited = 1;
                continue;
            }
            if (visited == 5)
                maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen == -1 ? 0 : maxLen;
    }

    public static void main(String[] args) {
        String word = "aeiou";
        System.out.println(new Q3().longestBeautifulSubstring(word));
    }
}
