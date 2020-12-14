package Medium;

import java.util.*;

public class FindTheMostCompetitiveSubsequence {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] res = new int[k];
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] < o2[0])
                return -1;
            else if (o1[0] > o2[0])
                return 1;
            else
                return Integer.compare(o1[1], o2[1]);
        });
        for (int i = 0; i < nums.length - k + 1; i++)
            queue.add(new int[]{nums[i], i});
        int index = 0;
        int[] pair = queue.poll();
        res[index++] = pair[0];
        int edge = pair[1];

        for (int i = 0; i < k - 1; i++) {
            queue.add(new int[]{nums[nums.length - k + 1 + i], nums.length - k + 1 + i});
            List<int[]> save = new ArrayList<>();
            while (!queue.isEmpty()) {
                pair = queue.poll();
                if (pair[1] < edge)
                    continue;
                if (pair[1] > edge && nums.length - pair[1] >= k - i - 1)
                    break;
                save.add(pair);
            }
            res[index++] = pair[0];
            edge = pair[1];
            queue.addAll(save);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 4, 6};
        int k = 4;
        FindTheMostCompetitiveSubsequence sequence = new FindTheMostCompetitiveSubsequence();
        System.out.println(Arrays.toString(sequence.mostCompetitive(nums, k)));
    }
}
