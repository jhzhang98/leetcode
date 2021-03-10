package biweekly.w47;

import java.util.HashSet;
import java.util.Set;

public class Q2 {
    private int getBase(int n){
        long base = 1;
        while(base <= n)
            base *= 3;
        base /= 3;
        return (int) base;
    }
    public boolean checkPowersOfThree(int n) {
        Set<Integer> baseSet = new HashSet<>();
        while(true){
            int base = getBase(n);
            if (baseSet.contains(base))
                return false;
            baseSet.add(base);
            n -= base;
            if (n == 0)
                return true;
            else if (n == 2)
                return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q2().checkPowersOfThree(2));
    }
}
