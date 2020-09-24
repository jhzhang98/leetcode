package Easy;

public class MissingNumber {
    /***
     * 求和一减就好
     */
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        return (nums.length) * (nums.length + 1) / 2 - sum;
    }
}
