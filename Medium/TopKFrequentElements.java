package Medium;

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        int[][] save = new int[map.keySet().size()][2];
        int index = 0;
        for (int key : map.keySet())
            save[index++] = new int[]{key, map.get(key)};
        Arrays.sort(save, (o1, o2) -> Integer.compare(o2[1], o1[1]));
        int[] res = new int[k];
        for (int i=0 ; i<k ; i++)
            res[i] = save[i][0];
        return res;
    }
}
