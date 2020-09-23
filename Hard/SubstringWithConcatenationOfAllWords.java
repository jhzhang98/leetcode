package Hard;

import java.util.*;
import java.util.stream.Collectors;

public class SubstringWithConcatenationOfAllWords {
    private final List<Integer> res = new ArrayList<>();
    private int nextWordStart = -1;
    private int sequenceStart = 0;

    public List<Integer> findSubstring(String s, String[] words) {
        if (words[0].length() == 0)
            return res;
        while (true) {
            if (0 == nextSequence(s, words))
                break;
        }
        return res;
    }

    private int nextSequence(String s, String[] words) {
        int wordLen = words[0].length();
//        Set<String> wordSet = Arrays.stream(words).collect(Collectors.toSet());
        HashMap<String, Integer> wordRemained = new HashMap<>();
        for (String word : words){
            if (wordRemained.containsKey(word))
                wordRemained.put(word, wordRemained.get(word) + 1);
            else
                wordRemained.put(word, 1);
        }
        String firstWord = nextWord(sequenceStart, s, wordRemained, wordLen);
        if (firstWord == null)
            return 0;
        sequenceStart = nextWordStart;
        if (s.length() - sequenceStart < words[0].length() * words.length)
            return 0;
        if (wordRemained.get(firstWord) == 1)
            wordRemained.remove(firstWord);
        else
            wordRemained.put(firstWord, wordRemained.get(firstWord) - 1);
        // 从下一个单词开始
        for (int i = nextWordStart + wordLen; ; i += wordLen) {
            if (s.length() - i < wordLen * wordRemained.size() && wordRemained.size() != 0)
                return 0;
            if (wordRemained.size() == 0) {
                res.add(sequenceStart);
                sequenceStart += wordLen;
                return 1;
            }
            String nextWord = s.substring(i, i + wordLen);
            if (!wordRemained.containsKey(nextWord)) {
                sequenceStart += wordLen;
                return nextSequence(s, words);
            }
            if (wordRemained.get(nextWord) == 1)
                wordRemained.remove(nextWord);
            else
                wordRemained.put(nextWord, wordRemained.get(nextWord) - 1);
        }
    }

    private String nextWord(int startIndex, String s, Map<String, Integer> wordSet, int wordLen) {
        for (int i = startIndex; i + wordLen <= s.length(); i++) {
            String word = s.substring(i, i + wordLen);
            if (wordSet.containsKey(word)) {
                nextWordStart = i;
                return word;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords sub = new SubstringWithConcatenationOfAllWords();
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "good"};
        System.out.println(sub.findSubstring(s, words));
    }
}
