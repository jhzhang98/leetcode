package Easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAStream {

}

class KthLargest {
    PriorityQueue<Integer> window = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums)
            window.add(num);
        while(window.size() >= k)
            window.poll();
    }

    public int add(int val) {
        window.add(val);
        while(window.size() >= k)
            window.poll();
        return window.peek();
    }
}