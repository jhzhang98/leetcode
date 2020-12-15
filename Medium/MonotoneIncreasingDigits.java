package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonotoneIncreasingDigits {
    private int changeToNum(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res = res * 10;
            res += n;
        }
        return res;
    }

    private boolean checkFeat(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            if (nums[i] < nums[i - 1])
                return false;
        return true;
    }

    public int monotoneIncreasingDigits(int N) {
        List<Integer> NLst = new ArrayList<>();
        int tmp = N;
        while (tmp != 0) {
            NLst.add(tmp % 10);
            tmp = tmp / 10;
        }
        int[] num = new int[NLst.size()];
        for (int i = 0; i < NLst.size(); i++)
            num[i] = NLst.get(NLst.size() - i - 1);
        int[] res = Arrays.copyOf(num, num.length);

        for (int i = res.length - 1; i >= 0; i--) {
            if (checkFeat(res))
                break;

            boolean borrow = false;
            for (int j = 0; j < i; j++) {
                if (res[j] != 0) {
                    borrow = true;
                    break;
                }
            }

            if (!borrow) {   // 1. 前面都是0，没法借位
                if (res[i] != 0)
                    res[i]--;
                break;
            } else {        // 2. 向前借位
                int borrowIndex = i - 1;
                for (; borrowIndex >= 0; borrowIndex--) {
                    if (res[borrowIndex] != 0)
                        break;
                }
                res[borrowIndex]--;
                for (int j = borrowIndex + 1; j <= i; j++)
                    res[j] = 9;
            }
        }

        return changeToNum(res);
    }

    public static void main(String[] args) {
        MonotoneIncreasingDigits digits = new MonotoneIncreasingDigits();
        int N = 10;
        System.out.println(digits.monotoneIncreasingDigits(N));
    }
}
