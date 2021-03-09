package Hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        // 0: index, 1: num
        TreeSet<int[]> window = new TreeSet<>((o1, o2) -> {
            if (o1[0] == o2[0]) return 0;
            else if (o1[1] > o2[1]) return 1;
            else if (o1[1] < o2[1]) return -1;
            else return Integer.compare(o1[0], o2[0]);
        });
        for (int i = 0; i < k; i++)
            window.add(new int[]{i, nums[i]});
        double[] res = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            if (i > 0) {
                window.remove(new int[]{i - 1, nums[i - 1]});
                window.add(new int[]{i + k - 1, nums[i + k - 1]});
            }
            double median = -1;
            int count = 0;
            int index = k / 2;
            if (k % 2 == 0) {
                for (int[] pair : window) {
                    int num = pair[1];
                    if (count == index - 1)
                        median = num;
                    else if (count == index) {
                        median += num;
                        median /= 2;
                        break;
                    }
                    count++;
                }
            } else {
                for (int[] pair : window) {
                    int num = pair[1];
                    if (count == index) {
                        median = num;
                        break;
                    }
                    count++;
                }
            }
            res[i] = median;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {56, 8, 56, 634, 5, 345, 235, 4, 6};
        int k = 3;
        System.out.println(Arrays.toString(new SlidingWindowMedian().medianSlidingWindow(nums, k)));
    }
}
