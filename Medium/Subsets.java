package Medium;

import java.util.*;

public class Subsets {
    private boolean[] count;

    private boolean upDateCount() {
        if (!count[count.length - 1]) {
            count[count.length - 1] = true;
            return true;
        }
        for (int i = count.length - 1; i >= 0; i--) {
            if (i == 0 && count[i])
                return false;
            if (count[i])
                count[i] = false;
            else if (!count[i]) {
                count[i] = true;
                return true;
            }
        }
        return false;
    }

    private List<Integer> getNext(int[] nums) {
        List<Integer> seq = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i])
                seq.add(nums[i]);
        }

        if (!upDateCount())
            count = null;
        return seq;
    }

    public List<List<Integer>> subsets(int[] nums) {
        count = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        while (count != null) {
            res.add(getNext(nums));
        }
        return res;
    }

    public static void main(String[] args) {
        Subsets sub = new Subsets();
        int[] nums = {};
        System.out.println(sub.subsets(nums));
    }
}
