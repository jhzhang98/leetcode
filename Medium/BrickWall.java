package Medium;

import java.util.*;

public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Long, Integer> freq = new HashMap<>();
        for (List<Integer> row : wall) {
            long start = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                long index = start + row.get(i);
                freq.put(index, freq.getOrDefault(index, 0) + 1);
                start = index;
            }
        }

        int maxFreq = 0;
        for (long key : freq.keySet())
            maxFreq = Math.max(maxFreq, freq.get(key));

        return wall.size() - maxFreq;
    }

    public static void main(String[] args) {
        List<List<Integer>> test = new ArrayList<>();
//        test.add(Arrays.asList(1, 2, 2, 1));
//        test.add(Arrays.asList(3, 1, 2));
//        test.add(Arrays.asList(1, 3, 2));
//        test.add(Arrays.asList(2, 4));
//        test.add(Arrays.asList(3, 1, 2));
//        test.add(Arrays.asList(1, 3, 1, 1));

//        test.add(Arrays.asList(1, 1));
//        test.add(Arrays.asList(1, 1));
//        test.add(Arrays.asList(1, 1));

//        test.add(Arrays.asList(new Integer[]{1}));
//        test.add(Arrays.asList(new Integer[]{1}));
//        test.add(Arrays.asList(new Integer[]{1}));

        test.add(Arrays.asList(9, 1));
        test.add(Arrays.asList(6, 3, 1));
        test.add(Arrays.asList(2, 4, 1, 3));

        System.out.println(new BrickWall().leastBricks(test));
    }
}
