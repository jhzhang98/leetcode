package Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sum = Arrays.stream(A).sum() + Arrays.stream(B).sum();
        int candyDiff = sum / 2 - Arrays.stream(A).sum();
        Set<Integer> set = new HashSet<>();
        for (int candy : B) set.add(candy);

        for (int candy : A) {
            if (set.contains(candy + candyDiff))
                return new int[]{candy, candy + candyDiff};
        }
        return null;
    }
}
