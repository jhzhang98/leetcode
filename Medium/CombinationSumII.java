package Medium;

import java.util.*;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curPath = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, 0, curPath, target, res);
        return res;
    }

    private void dfs(int[] candidates, int index, int curSum, List<Integer> path, int target, List<List<Integer>> res) {
        if (curSum == target) {
            res.add(new ArrayList<>(path));
        } else if (curSum < target) {
            Set<Integer> visited = new HashSet<>();
            for (int i = index; i < candidates.length; i++) {
                if (visited.contains(candidates[i])) continue;
                if (curSum + candidates[i] > target) break;
                visited.add(candidates[i]);
                path.add(candidates[i]);
                dfs(candidates, i + 1, curSum + candidates[i], path, target, res);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 2, 1, 2, 1, 5, 2, 1, 2};
        int target = 5;
        System.out.println(new CombinationSumII().combinationSum2(candidates, target));
    }
}
