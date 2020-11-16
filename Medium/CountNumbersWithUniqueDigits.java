package Medium;

import java.util.Arrays;

public class CountNumbersWithUniqueDigits {
    /***
     * 排列组合问题
     * 0<= x < 10^n 中，各个位数都不相同的有两种算法，
     * 一是全部减去存在相同的，重复情况太多，不好算
     * 二是一位一位加上来
     *
     * f(k) = k位不相同的数字个数
     * f(k+1) = f(k) * (10 - k )
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        int[] f = new int[11];
        f[1] = 10;
        f[2] = 81;
        for (int i = 3; i <= n && i < f.length; i++)
            f[i] = f[i - 1] * (10 - i + 1);

        int sum = 0;
        for (int i = 1; i <= n && i < f.length; i++)
            sum += f[i];
        return sum;
    }

    public static void main(String[] args) {
        CountNumbersWithUniqueDigits digits = new CountNumbersWithUniqueDigits();
        int n = 11;
        System.out.println(digits.countNumbersWithUniqueDigits(n));
    }
}
