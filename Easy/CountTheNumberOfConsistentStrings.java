package Easy;

import java.util.*;

public class CountTheNumberOfConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (char c : allowed.toCharArray())
            set.add(c);
        int res = 0;
        for (String word : words){
            boolean addOne = true;
            for (char c : word.toCharArray()){
                if (!set.contains(c)){
                    addOne = false;
                    break;
                }
            }
            res += (addOne) ? 1 : 0;
        }
        return res;
    }
}
