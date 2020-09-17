package Easy;

import java.util.Arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null)
            return 0;
        int count = 0;
        int vacant = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                count++;
                if (vacant == -1) vacant = i;
            } else if (vacant != -1) {
                nums[vacant] = nums[i];     // 让nums[i]的值填补到当前空缺
                nums[i] = val;              // 此时nums[i]也是空缺，所以设置为val
                count--;                    // 手动多了一个val，减一
                i--;                        // 防止nums[i]被放到i+1的位置，重新看一遍
                for (int j = vacant; j < nums.length; j++) {
                    if (nums[j] == val) {
                        vacant = j;
                        break;
                    }
                }
            }
        }
        return nums.length - count;
    }

    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        int[] nums = {3, 2, 2, 3, 3};
        int val = 3;
        System.out.println(re.removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }
}
