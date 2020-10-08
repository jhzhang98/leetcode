package Medium;

import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        int zeroCount = 0;
        int oneCount = 0;
        for (int num : nums) {
            switch (num) {
                case 0:
                    zeroCount++;
                    break;
                case 1:
                    oneCount++;
                    break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < zeroCount)
                nums[i] = 0;
            else if (i < zeroCount + oneCount)
                nums[i] = 1;
            else
                nums[i] = 2;
        }
    }

    public static void main(String[] args) {
        SortColors colors = new SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};
        colors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
