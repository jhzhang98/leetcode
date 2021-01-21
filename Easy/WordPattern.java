package Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        if (pattern.length() == 0 && s.length() == 0)
            return true;
        String[] dict = new String[26];
        String[] words = s.split(" ");
        if (words.length != pattern.length())
            return false;
        Set<String> searched = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            int c = pattern.charAt(i);
            if (dict[c - 'a'] == null) {
                if (searched.contains(words[i]))
                    return false;
                dict[c - 'a'] = words[i];
                searched.add(words[i]);
            } else if (!dict[c - 'a'].equals(words[i]))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        WordPattern pattern = new WordPattern();
        String pat = "";
        String s = "";
        System.out.println(pattern.wordPattern(pat, s));
    }
}
