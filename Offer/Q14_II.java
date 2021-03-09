package Offer;

public class Q14_II {
    public int cuttingRope(int n) {
        if (n <= 3)
            return n-1;
        int count3 = 0, count2 = 0;
        while (n >= 3) {
            count3++;
            n -= 3;
        }
        if (n == 2) {
            count2++;
        } else if (n == 1) {
            count3 -= 1;
            count2 = 2;
        }

        long res = pow(3, count3);
        if (count2 == 1)
            return (int) (res * 2 % 1000000007);
        else if (count2 == 2)
            return (int) (res * 4 % 1000000007);
        else
            return (int) res;
    }

    private long pow(int x, int y) {
        if (y == 1)
            return x;
        else if (y == 0)
            return 1;
        else
            return (pow(x, y / 2) * pow(x, y - y / 2) % 1000000007);
    }

    public static void main(String[] args) {
        Q14_II q = new Q14_II();
        System.out.println(q.cuttingRope(1000));
    }
}
