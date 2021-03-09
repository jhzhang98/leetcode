package Hard;

import java.util.*;

public class SubarraysWithKDifferentIntegers {
    private int atMostDistinct(int[] A, int K) {
        Map<Integer, Integer> save = new HashMap<>();
        int count = 0;
        int res = 0;
        int left = 0, right = 0;
        while (right < A.length) {
            if (save.containsKey(A[right])) {
                save.put(A[right], save.get(A[right]) + 1);
            } else {
                save.put(A[right], 1);
                count++;        // 每添加一个合法元素，增加一个计数
            }

            while (count > K) {
                if (save.get(A[left]) == 1) {
                    save.remove(A[left]);
                    count--;        // 每失去一个非法元素，减少一次计数
                } else {
                    save.put(A[left], save.get(A[left]) - 1);
                }
                left++;
            }

            res += right - left; // 每新增一个合法元素，新增right - left个子序列
            right++;
        }
        return res;
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostDistinct(A, K) - atMostDistinct(A, K - 1);
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 1, 2, 3};
        int K = 2;
        System.out.println(new SubarraysWithKDifferentIntegers().subarraysWithKDistinct(A, K));
        List<Integer> res = new ArrayList<>();
        res.add(1);
        res.add(2);
        res.add(3);
        Collections.reverse(res);
        System.out.println(res);
    }
}
