package Medium;

import java.util.Arrays;

public class Offer56 {
    /***
     * x ^ x = 0
     * x ^ 0 = x
     * nums = (a1, a2, ..., ak), (a1, a2, ..., ak), b1, b2
     * 做异或操作得到c = b1 ^ b2
     * 将所有数字按照c中第一个为1的位数分为两组
     * 这里利用以前学过的数独问题中, a & -a可以直接得到最低位的1
     * 分别做异或得到对应结果
     */
    public int[] singleNumbers(int[] nums) {
        int c = 0;
        for (int num : nums)
            c ^= num;
        int par = c & -c;
        int left = 0, right = 0;
        for (int num : nums) {
            if ((par & num) == 0)
                left ^= num;
            else
                right ^= num;
        }
        return new int[]{left, right};
    }

    public static void main(String[] args) {
        Offer56 offer = new Offer56();
        int[] nums = {1,2,10,4,1,4,3,3};
        System.out.println(Arrays.toString(offer.singleNumbers(nums)));
    }
}
