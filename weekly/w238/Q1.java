package weekly.w238;

public class Q1 {
    public int sumBase(int n, int k) {
        long base = 1;
        while(base <= n)
            base *= k;
        base /= k;
        int res = 0;
        while(n != 0){
            res += n / base;
            n = (int) (n % base);
            base = base / k;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 2, k = 2;
        System.out.println(new Q1().sumBase(n, k));
        System.out.println(Integer.toBinaryString(n));
    }
}
