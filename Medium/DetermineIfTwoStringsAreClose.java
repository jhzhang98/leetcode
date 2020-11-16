package Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;
        int[] word1Count = new int[26];
        int[] word2Count = new int[26];
        HashSet<Character> word1CharSet = new HashSet<>();
        HashSet<Character> word2CharSet = new HashSet<>();
        for (int i = 0; i < word1.length(); i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            word1CharSet.add(c1);
            word2CharSet.add(c2);
            word1Count[c1 - 'a']++;
            word2Count[c2 - 'a']++;
        }

        Set<Integer> word1Set = new HashSet<>();
        Set<Integer> word2Set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            word1Set.add(word1Count[i]);
            word2Set.add(word2Count[i]);
        }
        return word1Set.equals(word2Set) && word1CharSet.equals(word2CharSet);
    }
}
