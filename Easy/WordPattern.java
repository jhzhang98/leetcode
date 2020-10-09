package Easy;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        if (pattern.length() == 0 && s.length() == 0)
            return true;
        String[] items = s.split("[ ]");
        if (pattern.length() != items.length)
            return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)){
                if (!map.get(c).equals(items[i]))
                    return false;
            }else{
                map.put(c, items[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern pattern = new WordPattern();
        String pat = "";
        String s  = "";
        System.out.println(pattern.wordPattern(pat, s));
    }
}
