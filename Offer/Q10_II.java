package Offer;

public class Q10_II {
    public int numWays(int n) {
        if (n == 0 || n == 1)
            return 1;
        int mask = 1000000007;
        long a = 1, b = 1;
        int count = 1;
        while (count < n) {
            long c = a + b;
            a = b;
            b = c % mask;
            count++;
        }
        return (int) b;
    }

    public static void main(String[] args) {
        System.out.println(new Q10_II().numWays(4));
    }
}
