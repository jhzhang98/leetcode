package Medium;

import java.util.LinkedList;
import java.util.List;

public class SplitArrayIntoFibonacciSequence {
    String S;
    int num1Len, num2Len;

    private boolean check(int num1, int num2, int k, String S) {
        return false;
    }

    public List<Integer> splitIntoFibonacci(String S) {
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(0) == '0')
                i = 0;
            long num1 = Long.parseLong(S.substring(0, i + 1));
            if (num1 > Integer.MAX_VALUE)
                return new LinkedList<>();
            for (int j = i + 1; j < S.length() && Math.max(i + 1, j - i) <= S.length() - j - 1; j++) {
                long num2 = Long.parseLong(S.substring(i + 1, j + 1));
                if (num2 > Integer.MAX_VALUE || num1 + num2 > Integer.MAX_VALUE)
                    break;

            }
        }
        return null;
    }
}
