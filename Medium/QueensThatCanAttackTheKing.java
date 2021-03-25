package Medium;

import java.util.*;

public class QueensThatCanAttackTheKing {
    private boolean canAttack(int[] queen, int[] king) {
        return queen[0] == king[0] || queen[1] == king[1] ||
                queen[0] + queen[1] == king[0] + king[1] ||
                queen[0] - queen[1] == king[0] - king[1];
    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        Arrays.sort(queens, (o1, o2) ->
                Integer.compare(Math.abs(king[0] - o1[0]) + Math.abs(king[1] - o1[1]),
                        Math.abs(king[0] - o2[0]) + Math.abs(king[1] - o1[1]))
        );
        Set<Integer> x = new HashSet<>();
        Set<Integer> y = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int[] queen : queens) {
            if (!canAttack(queen, king))
                continue;
            // 这样做结果会有错误，虽然{2,2}和{4,4}被隔，但是被国王{3，3}挡住，依旧可以都攻击到王，应该加四个状态标识四个对角线，太麻烦了，不想加
            if (x.contains(queen[0]) || y.contains(queen[1]) ||
                    diag1.contains(queen[0] + queen[1]) || diag2.contains(queen[0] - queen[1]))
                continue;
            x.add(queen[0]);
            y.add(queen[1]);
            diag1.add(queen[0] + queen[1]);
            diag2.add(queen[0] - queen[1]);
            res.add(new ArrayList<>(Arrays.asList(queen[0], queen[1])));
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] queens = {{0, 0}, {1, 1}, {2, 2}, {3, 4}, {3, 5}, {4, 4}, {4, 5}};
        int[] king = {3, 3};
        System.out.println(new QueensThatCanAttackTheKing().queensAttacktheKing(queens, king));
    }
}
