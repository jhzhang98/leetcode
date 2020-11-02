package Easy;

import java.util.Arrays;
import java.util.Comparator;

public class CheckArrayFormationThroughConcatenation {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        boolean[] arrMatch = new boolean[arr.length];
        Arrays.fill(arrMatch, false);
        Arrays.sort(pieces, Comparator.comparingInt(o -> -o.length));
        for (int[] piece : pieces) {
            int matchStartIndex = match(arr, piece, arrMatch);
            if (matchStartIndex == -1)
                return false;
            for (int i = 0; i < piece.length; i++)
                arrMatch[i + matchStartIndex] = true;
        }

        for (boolean match : arrMatch)
            if (!match)
                return false;
        return true;
    }

    private int match(int[] arr, int[] piece, boolean[] arrMatch) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == piece[0] && !arrMatch[i]) {
                boolean match = true;
                for (int j = 0; j < piece.length; j++) {
                    if (j + i >= arr.length) {
                        match = false;
                        break;
                    }
                    if (arr[j + i] != piece[j])
                        match = false;
                    if (arrMatch[j + i])
                        match = false;
                }
                if (match) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
}
