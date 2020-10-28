package Easy;

import java.util.Arrays;
import java.util.Comparator;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[][] numsIndex = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            numsIndex[i][1] = i;
            numsIndex[i][0] = nums[i];
        }

        Arrays.sort(numsIndex, (o1, o2) -> {
            if (o1[0] < o2[0])
                return -1;
            else if (o1[0] > o2[0])
                return 1;
            else
                return Integer.compare(o1[1], o2[1]);
        });
        nums[numsIndex[0][1]] = 0;

        int lastCount = 0;
        for (int i = 1; i < nums.length; i++) {
            int index = numsIndex[i][1];
            int num = numsIndex[i][0];
            if (numsIndex[i - 1][0] == num) {
                nums[index] = lastCount;
            } else {
                lastCount = i;
                nums[index] = i;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        HowManyNumbersAreSmallerThanTheCurrentNumber number = new HowManyNumbersAreSmallerThanTheCurrentNumber();
        int[] nums = {7,7,7,7};
        System.out.println(Arrays.toString(number.smallerNumbersThanCurrent(nums)));
    }
}
