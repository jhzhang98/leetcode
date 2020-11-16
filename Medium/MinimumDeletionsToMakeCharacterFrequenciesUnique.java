package Medium;

import java.util.*;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;
        int move = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < freq.length; i++)
            if (freq[i] != 0) {
                if (map.containsKey(freq[i]))
                    map.get(freq[i]).add(i);
                else {
                    List<Integer> lst = new ArrayList<>();
                    lst.add(i);
                    map.put(freq[i], lst);
                }
            }
        Set<Integer> keySet = new HashSet<>(map.keySet());
        for (int key : keySet) {
            List<Integer> lst = map.get(key);
            int moveNum = lst.size() - 1;
            if (moveNum == 0)
                continue;
            while (moveNum != 0) {
                int charFreq = key;
                while (map.containsKey(charFreq--))
                    move++;
                if (charFreq != -1) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(-1);
                    map.put(charFreq + 1, tmp);
                }
                moveNum--;
            }
        }

        return move;
    }

    public static void main(String[] args) {
        MinimumDeletionsToMakeCharacterFrequenciesUnique unique = new MinimumDeletionsToMakeCharacterFrequenciesUnique();
        System.out.println(unique.minDeletions("accdcdadddbaadbc"));
    }

}
