package Medium;

import java.util.*;

public class Permutations {
    private void getNextNum(Set<Integer> seqNum, List<Integer> curSeq, List<List<Integer>> res, int[] nums) {
        if (curSeq.size() == nums.length) {
            res.add(curSeq);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (seqNum.contains(nums[i]))
                continue;
            int num = nums[i];
            List<Integer> nextSeq = new ArrayList<>(curSeq);
            nextSeq.add(num);
            Set<Integer> nextSeqNum = new HashSet<>(nextSeq);
            getNextNum(nextSeqNum, nextSeq, res, nums);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> seqNum = new HashSet<>();
        List<Integer> curSeq = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        getNextNum(seqNum, curSeq, res, nums);
        return res;
    }

    public static void main(String[] args) {
        Permutations per = new Permutations();
        int[] nums = {};
        System.out.println(per.permute(nums));
    }
}
