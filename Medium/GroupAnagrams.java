package Medium;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new LinkedList<>();

        for (String str : strs) {
            char[] word = str.toCharArray();
            Arrays.sort(word);
            String wordSorted = String.valueOf(word);
            if (!map.containsKey(wordSorted)) {
                map.put(wordSorted, new LinkedList<>());
            }
            map.get(wordSorted).add(str);
        }

        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

    public static void main(String[] args) {
        GroupAnagrams anagrams = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        for (List<String> res : anagrams.groupAnagrams(strs))
            System.out.println(res);
    }
}
