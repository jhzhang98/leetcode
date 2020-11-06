package Easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortIntegersByTheNumberOf1Bits {
    private int getOneBits(int num) {
        int res = 0;
        while (num > 0) {
            res += (num & 1);
            num >>= 1;
        }
        return res;
    }

    public int[] sortByBits(int[] arr) {
        List<Integer> arr2 = Arrays.stream(arr).boxed().sorted((o1, o2) -> {
            if (getOneBits(o1) > getOneBits(o2))
                return 1;
            else if (getOneBits(o1) < getOneBits(o2))
                return -1;
            else
                return Integer.compare(o1, o2);
        }).collect(Collectors.toList());
        return arr2.stream().mapToInt(Integer::valueOf).toArray();
    }
}
