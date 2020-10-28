package Medium;

import java.util.*;

public class ArithmeticSubarrays {


    private boolean check(int[] nums, int start, int end) {
        int[] numCp = new int[end - start + 1];
        if (numCp.length <= 2)
            return true;
        System.arraycopy(nums, start, numCp, 0, end - start + 1);
        Arrays.sort(numCp);
        int dis = numCp[1] - numCp[0];
        for (int i = 1; i < numCp.length; i++) {
            if (dis != numCp[i] - numCp[i - 1])
                return false;
        }
        return true;
    }

    /**
     * 暴力
     */
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new LinkedList<>();
        for (int i = 0; i < l.length; i++) {
            int start = l[i];
            int end = r[i];
            res.add(check(nums, start, end));
        }
        return res;
    }

}
