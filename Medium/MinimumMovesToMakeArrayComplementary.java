package Medium;

import java.util.*;

public class MinimumMovesToMakeArrayComplementary {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] sum = new int[nums.length / 2];
        List<int[]> save = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sum.length; i++) {
            sum[i] = nums[i] + nums[n - i - 1];
            if (map.containsKey(sum[i]))
                map.put(sum[i], map.get(sum[i]) + 1);
            else
                map.put(sum[i], 1);
        }
        for (int key : map.keySet())
            save.add(new int[]{key, map.get(key)});
        save.sort((o1, o2) -> {
            if (o1[0] == o2[0])
                return Integer.compare(Math.abs(o1[0] - limit), Math.abs(o2[0] - limit));
            return Integer.compare(o2[1], o1[1]);
        });

        int minMoves = Integer.MAX_VALUE;
        int testNum = Math.min(1000, save.size());

        for (int i = 0; i < testNum; i++) {
            int[] pair = save.get(i);
            int count = 0;
            int pairSum = pair[0];
            for (int j = 0; j < sum.length; j++) {
                if (pairSum != sum[j]) {
                    if (nums[j] < pairSum - limit && nums[n - j - 1] < pairSum - limit)
                        count += 2;
                    else
                        count += 1;
                }
                minMoves = Math.min(count, minMoves);
            }
        }
        return minMoves;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3};
        int limit = 4;
        MinimumMovesToMakeArrayComplementary complementary = new MinimumMovesToMakeArrayComplementary();
        System.out.println(complementary.minMoves(nums, limit));
    }
}
