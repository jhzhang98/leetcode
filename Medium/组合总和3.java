package Medium;

import java.util.*;

public class 组合总和3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        search(0, 1, k, n, new ArrayList<>(), result);
        return result;
    }

    private void search(int sum, int currentNum, int k, int n, List<Integer> combination, List<List<Integer>> allRes) {
        if (sum == n && combination.size() == k) {
            List<Integer> tmp = new ArrayList<>(combination);
            allRes.add(tmp);
            return;
        }

        if (combination.size() == k)
            return;

        for (; currentNum < 10; currentNum++) {
            if (sum + currentNum > n) return;
            combination.add(currentNum);
            search(sum + currentNum, currentNum + 1, k, n, combination, allRes);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        组合总和3 test = new 组合总和3();
        int k = -4, n = -2;
        System.out.println(test.combinationSum3(k, n));
    }
}
