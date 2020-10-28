package Easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAStream {

}

class KthLargest {
    Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums)
            queue.add(num);
    }

    public int add(int val) {
        queue.add(val);
        int[] save = new int[k];
        for (int i = 0; i < k; i++)
            save[i] = queue.poll();

        int res = save[k - 1];
        for (int num : save)
            queue.add(num);
        return res;
    }
}