package Hard;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {
    private int wordStart = -1;

    private String nextWord(String s, int start, Set<String> words) {
        return null;
    }

    private boolean allUsed(boolean[] wordUsed) {
        for (boolean tag : wordUsed)
            if (!tag)
                return false;
        return true;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0 || words[0].length() == 0)
            return new ArrayList<>();
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        boolean[] wordUsed = new boolean[words.length];
        Arrays.fill(wordUsed, false);
        int sequenceStart = -1;
        int currentStart = -1;
        boolean haveASequence = false;
        while (true) {
            String word = nextWord(s, currentStart + 1, wordSet);
            if (word == null) {
                if (!allUsed(wordUsed))
                    return new ArrayList<>();
                break;
            }

            if (!haveASequence) {
                sequenceStart = wordStart;
                break;
            } else {
                if (wordStart != currentStart + words[0].length());
            }
        }
        return null;
    }
}
