package Hard;

import java.util.*;

public class NumbersWithRepeatedDigits {
    /**
     * 计算A(n, m)
     */
    private int permutation(int n, int m) {
        int sum = 1;
        for (int i = n; i > n - m + 1; i--) {
            sum *= i;
        }
        return sum;
    }

    public int numDupDigitsAtMostN(int N) {
        // 1. 判断N每一位有多少数可以取
        List<Integer> number = new ArrayList<>();
        int Ncp = N;
        while (Ncp > 0) {
            number.add(Ncp % 10);
            Ncp /= 10;
        }
        int[] num = new int[number.size()];
        for (int i = 0; i < num.length; i++) {
            num[i] = number.get(i);
        }
        System.out.println(Arrays.toString(num));

        return 0;
    }

    public static void main(String[] args) {
        NumbersWithRepeatedDigits number = new NumbersWithRepeatedDigits();
        int N = 1857;
        System.out.println(number.numDupDigitsAtMostN(1857));
    }
}
