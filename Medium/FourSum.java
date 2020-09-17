package Medium;

import com.sun.corba.se.spi.orbutil.fsm.FSM;

import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        int a = 0, b = 1;
        while (a < nums.length - 3) {
            if (b > a + 1 && nums[b] == nums[b - 1]) {
                if (b < nums.length - 2)
                    b++;
                else
                    b = ++a + 1;
                continue;
            }

            if (a > 0 && nums[a] == nums[a - 1]) {
                a++;
                b = a + 1;
                continue;
            }

            int num1 = nums[a];
            int num2 = nums[b];
            int locTarget = target - (num1 + num2);

            int left = b + 1, right = nums.length - 1;
            if (left >= right) { // 说明 b到头了，没有组合了，此时将a+1，b=a+1
                b = ++a + 1;
                continue;
            }
            while (left < right) {
                if (left > b + 1 && nums[left - 1] == nums[left]) {
                    left++;
                    continue;
                }
                if (right < nums.length - 2 && nums[right + 1] == nums[right]) {
                    right--;
                    continue;
                }
                if (nums[left] + nums[right] > locTarget) {
                    right--;
                } else if (nums[left] + nums[right] < locTarget) {
                    left++;
                } else {
                    res.add(Arrays.asList(num1, num2, nums[left], nums[right]));
                    left++;
                }
            }
            b++;
        }
        return res;
    }

    public static void main(String[] args) {
        FourSum fs = new FourSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(fs.fourSum(nums, -1));
    }
}
