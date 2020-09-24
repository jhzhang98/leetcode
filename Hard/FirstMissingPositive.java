package Hard;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        // 标记一下，其实就相当于另开劈一个tag数组，记录小于num.length的数字是否出现过
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < nums.length && num >= 0 && nums[num] != num) {
                nums[i] = nums[num];
                nums[num] = num;
                i--;
            }
        }

        // 由于是最小未出现正整数，从1开始找，一旦找到tag未标记的，返回index
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }

        // 遍历结束，说明位置全对，那特殊情况全在nums[0]上
        if (nums.length == 1)   // 长度为1
            return nums[0] == 1 ? 2 : 1;
        if (nums.length == 0)   // 长度为0
            return 1;
        return nums[0] == nums[nums.length - 1] + 1 ? nums[0] + 1 : nums[nums.length - 1] + 1;  // 防止如[2, 1]这样把nums[n-1]+1藏在nums[0]上的情况
    }

    public static void main(String[] args) {
        FirstMissingPositive missingPositive = new FirstMissingPositive();
        int[] nums = {2, 1, 2};
        System.out.println(missingPositive.firstMissingPositive(nums));
    }
}
