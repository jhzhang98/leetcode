package Medium;

public class DecreaseElementsToMakeArrayZigzag {

    /**
     * 偶数索引，减奇数位
     */
    private int evenZigzag(int[] numsGlobal) {
        int[] nums = new int[numsGlobal.length];
        System.arraycopy(numsGlobal, 0, nums, 0, nums.length);
        int count = 0;
        for (int i = 1; i < nums.length; i += 2) {
            if (i + 1 < nums.length) {
                if (nums[i + 1] >= nums[i]) {
                    count += (nums[i + 1] - nums[i]) + 1;
                    nums[i + 1] = nums[i] - 1;
                }
            }
            if (nums[i - 1] >= nums[i]) {
                count += (nums[i - 1] - nums[i]) + 1;
                nums[i - 1] = nums[i] - 1;
            }
        }
        return count;
    }

    /***
     * 奇数索引，减偶数位
     */
    private int oddZigzag(int[] numsGlobal) {
        int[] nums = new int[numsGlobal.length];
        System.arraycopy(numsGlobal, 0, nums, 0, nums.length);
        int count = 0;
        for (int i = 0; i < nums.length; i+=2) {
            if (i - 1 >= 0) {
                if (nums[i - 1] >= nums[i]) {
                    count += (nums[i - 1] - nums[i]) + 1;
                    nums[i - 1] = nums[i] - 1;
                }
            }
            if (i + 1 < nums.length && nums[i + 1] >= nums[i]) {
                count += (nums[i + 1] - nums[i]) + 1;
                nums[i + 1] = nums[i] - 1;
            }
        }
        return count;
    }


    public int movesToMakeZigzag(int[] nums) {
        int oddNum = oddZigzag(nums);
        int evenNum = evenZigzag(nums);
        return Math.min(oddNum, evenNum);
    }

    public static void main(String[] args) {
        DecreaseElementsToMakeArrayZigzag zigzag = new DecreaseElementsToMakeArrayZigzag();
        int[] nums = {9,6,1,6,2};
        System.out.println(zigzag.movesToMakeZigzag(nums));
    }

}
