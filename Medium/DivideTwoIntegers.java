package Medium;

public class DivideTwoIntegers {
    private int bitNumCount(long num) {   //记录num的比特位数
        int count = 0;
        long tmp = num;
        while (tmp > 0) {
            count++;
            tmp >>= 1;
        }
        return count;
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        int mask = 0x80000000;
        int sign1 = dividend & mask;
        int sign2 = divisor & mask;
        int sign = sign1 ^ sign2;
        long dividendAbs = (sign1 == mask) ? -(long) dividend : (long) dividend;
        long divisorAbs = (sign2 == mask) ? -(long) divisor : (long) divisor;
        long tmp = divisorAbs;
        int divisorCount = bitNumCount(divisorAbs);       // num位数
        int currentCount = divisorCount;
        while (tmp <= dividendAbs && currentCount < 31) {
            tmp <<= 1;
            currentCount += 1;
        }
        if (currentCount < 31)
            tmp >>= 1;

        long ans = 0;
        int curNum = 0;
        int ansBitNum = bitNumCount(tmp) - divisorCount + 1;    // 答案的位数
        while (curNum < ansBitNum) {
            if (tmp <= dividendAbs) {
                dividendAbs -= tmp;
                ans += 1;
            }
            ans <<= 1;
            tmp >>= 1;
            curNum++;
        }
        ans >>= 1;
        if (dividendAbs == divisorAbs)
            ans += 1;
        return (int) ((sign == mask) ? -ans : ans);
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(2147483647));
        System.out.println(Integer.toHexString(2147483647));
        DivideTwoIntegers dti = new DivideTwoIntegers();
        int dividend = Integer.MIN_VALUE, divisor = 4;
        System.out.println(dti.divide(dividend, divisor));
    }
}
