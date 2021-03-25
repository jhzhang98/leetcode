package Offer;

import java.util.ArrayList;
import java.util.List;

public class Q49 {
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] lst = new int[n];
        lst[0] = 1;
        int index = 1;

        while (index != n) {
            int x = lst[a] * 2;
            int y = lst[b] * 3;
            int z = lst[c] * 5;
            int min = Math.min(Math.min(x, y), z);
            lst[index++] = min;
            if (min == x) a++;
            if (min == y) b++;
            if (min == z) c++;
        }
        return lst[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Q49().nthUglyNumber(10));
    }
}
