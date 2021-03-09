package Medium;

import java.util.ArrayList;
import java.util.List;

public class FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> fib = new ArrayList<>();
        fib.add(1);
        fib.add(1);
        int index = 0;
        while (true) {
            int res = fib.get(index) + fib.get(index + 1);
            if (res > k)
                break;
            fib.add(res);
            index++;
        }
        index = fib.size() - 1;
        int count = 0;
        while (k != 0) {
            if (fib.get(index) > k) {
                index--;
            } else {
                k -= fib.get(index);
                count++;
            }
        }
        return count;
    }
}
