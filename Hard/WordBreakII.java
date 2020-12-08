package Hard;

import java.util.*;

public class WordBreakII {
    Set<String> wordSet;
    List<String> globalRes = new ArrayList<>();
    String s;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordSet = new HashSet<>(wordDict);
        this.s = s;
        search(0, 1, "");
        return globalRes;
    }

    private void search(int start, int end, String curRes) {
        if (end > s.length()) {
            if (start > s.length() - 1)
                globalRes.add(curRes.substring(1));
            return;
        }
        String sub = s.substring(start, end);
        if (wordSet.contains(sub)) {
            search(end, end + 1, curRes + " " + sub);
        }
        search(start, end + 1, curRes);
    }

    public static void main(String[] args) {
        WordBreakII breakII = new WordBreakII();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaa";
//        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        long start = System.currentTimeMillis();
        List<String> wordDict = new ArrayList<>(Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"));
        long end = System.currentTimeMillis();
        System.out.println(breakII.wordBreak(s, wordDict));
        System.out.println((end - start) / 1000f + "s");
    }
}
