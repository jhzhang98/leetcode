package Medium;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((o1, o2) -> {
            int f1 = o1.getValue();
            int f2 = o2.getValue();
            if (f1 < f2)
                return -1;
            else if (f1 > f2)
                return 1;
            else return o2.getKey().compareTo(o1.getKey());
        });
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            queue.add(e);
            if (queue.size() > k)
                queue.poll();
        }
        List<String> res = new LinkedList<>();
        while (!queue.isEmpty())
            res.add(0, queue.poll().getKey());
        return res;
    }
}
