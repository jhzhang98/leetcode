package weekly.w234;

import java.util.*;

public class Q1 {
    public int numDifferentIntegers(String word) {
        int left = 0, right = 0;
        Set<String> set = new HashSet<>();
        while (right < word.length() && left < word.length()) {
            if (word.charAt(left) <= '9' && word.charAt(left) >= '0') {
                while (right < word.length() && word.charAt(right) <= '9' && word.charAt(right) >= '0')
                    right++;
                int zeroIndex = left;
                while (zeroIndex < word.length() && word.charAt(zeroIndex) == '0')
                    zeroIndex++;
                if (zeroIndex != right)
                    set.add(word.substring(zeroIndex, right));
                else
                    set.add("0");
                left = right;
            } else {
                left++;
                right = left;
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        String word = "000b0c002";
        System.out.println(new Q1().numDifferentIntegers(word));
    }
}
