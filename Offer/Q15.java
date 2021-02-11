package Offer;

public class Q15 {
    public int hammingWeight(int n) {
        int sign = n & 0x80000000;
        n = n ^ sign;
        int count = (sign == 0x80000000) ? 1 : 0;
        while(n != 0){
            if ((n & 1) == 1)
                count++;
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int i = 0x8fffffef;
        i = i ^ 0x80000000;
        System.out.println(new Q15().hammingWeight(i));
    }
}
