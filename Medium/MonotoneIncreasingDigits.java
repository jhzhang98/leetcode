package Medium;

import java.util.ArrayList;
import java.util.List;

public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        boolean highestFeat = true;
        List<Integer> NLst = new ArrayList<>();
        int tmp = N;
        while (tmp != 0) {
            NLst.add(tmp % 10);
            tmp = tmp / 10;
        }
        List<Integer> res = new ArrayList<>();
        int highest = NLst.get(NLst.size() - 1);
        res.add(highest);
        return 0;
    }

    public static void main(String[] args) {
        MonotoneIncreasingDigits digits = new MonotoneIncreasingDigits();
        int N = 1234;
        System.out.println(digits.monotoneIncreasingDigits(N));
    }
}
