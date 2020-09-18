package Medium;

import java.util.*;

public class PermutationsII {

    private void getNextSeq(int[] nums, boolean[] numsUsed, Set<Integer> curPosSet, List<Integer> curSeq, List<List<Integer>> res) {
        if (curSeq.size() == nums.length) {
            res.add(curSeq);
            return;
        }
        boolean[] numsUsedLoc = new boolean[numsUsed.length];
        System.arraycopy(numsUsed, 0, numsUsedLoc, 0, nums.length);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (numsUsedLoc[i])
                continue;
            if (curPosSet.contains(num))
                continue;
            List<Integer> newSeq = new ArrayList<>(curSeq);
            newSeq.add(num);
            curPosSet.add(num);
            numsUsedLoc[i] = true;
            if (curPosSet.size() + curSeq.size() == nums.length)
                curPosSet = new HashSet<>();
            boolean[] numsUsedNext = new boolean[numsUsed.length];
            System.arraycopy(numsUsed, 0, numsUsedNext, 0, nums.length);
            numsUsedNext[i] = true;
            getNextSeq(nums, numsUsedNext, new HashSet<>(), newSeq, res);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> curSeqSet = new HashSet<>();
        List<Integer> curSeq = new ArrayList<>();
        boolean[] numsUsed = new boolean[nums.length];
        getNextSeq(nums, numsUsed, curSeqSet, curSeq, res);
        return res;
    }

    public static void main(String[] args) {
        PermutationsII per = new PermutationsII();
        int[] nums = {1};
        List<List<Integer>> res = per.permuteUnique(nums);
        for (List<Integer> seq : res)
            System.out.println(seq);
    }

}
