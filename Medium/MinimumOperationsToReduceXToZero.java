package Medium;

import java.util.HashMap;
import java.util.HashSet;

public class MinimumOperationsToReduceXToZero {
    public int minOperations(int[] nums, int x) {
        int[] sumLeft = new int[nums.length];
        int[] sumRight = new int[nums.length];
        sumLeft[0] = nums[0];
        sumRight[0] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            int sum = sumLeft[i - 1] + nums[i];
            if (sum > x)
                break;
            sumLeft[i] = sum;
        }
        for (int i = 1; i < nums.length; i++) {
            int sum = sumRight[i - 1] + nums[nums.length - 1 - i];
            if (sum > x)
                break;
            sumRight[i] = sum;
        }

        HashMap<Integer, Integer> mapLeft = new HashMap<>();
        mapLeft.put(0, 0);
        HashMap<Integer, Integer> mapRight = new HashMap<>();
        mapRight.put(0, 0);

        for (int i = 0; i < nums.length; i++) {
            if (sumLeft[i] == 0)
                break;
            mapLeft.put(sumLeft[i], i + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (sumRight[i] == 0)
                break;
            mapRight.put(sumRight[i], i + 1);
        }
        int move = Integer.MAX_VALUE;
        if (mapLeft.containsKey(x))
            move = mapLeft.get(x);
        for (int left : mapLeft.keySet()) {
            if (mapRight.containsKey(x - left)) {
                int leftIndex = mapLeft.get(left);
                int rightIndex = nums.length - mapRight.get(x - left);
                if (leftIndex < rightIndex)
                    move = Math.min(move, mapLeft.get(left) + mapRight.get(x - left));
            }
        }
        return move == Integer.MAX_VALUE ? -1 : move;
    }

    public static void main(String[] args) {
        MinimumOperationsToReduceXToZero zero = new MinimumOperationsToReduceXToZero();
        int[] nums = {1, 1, 1};
        int x = 3;
        System.out.println(zero.minOperations(nums, x));
    }
}
