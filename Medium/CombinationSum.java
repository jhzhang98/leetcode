package Medium;

import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, 0, new ArrayList<>(), target, res);
        return res;
    }

    private void dfs(int[] candidates, int index, int curSum, List<Integer> path, int target, List<List<Integer>> res) {
        if (curSum == target) {
            res.add(new ArrayList<>(path));
        } else if (curSum < target) {
            for (int i = index ; i<candidates.length ; i++){
                path.add(candidates[i]);

                dfs(candidates, i, curSum + candidates[i], path, target, res);

                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 0;
        System.out.println(new CombinationSum().combinationSum(candidates, target));
    }
}
