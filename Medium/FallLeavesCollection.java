package Medium;

public class FallLeavesCollection {
    int globalMove = Integer.MAX_VALUE;

    /***
     * dfs + 剪枝，超时
     * @param index which leave
     * @param state 0: left r
     *              1: middle y
     *              2: right r
     */
    private void nextLeaf(String leaves, int index, int moves, int state) {
        if (index == leaves.length()) {
            if (state == 2)
                globalMove = Math.min(globalMove, moves);
            return;
        }
        if (moves > globalMove)
            return;
        if (index == 0) {
            if (leaves.charAt(0) == 'r')
                nextLeaf(leaves, index + 1, moves, state);
            else
                nextLeaf(leaves, index + 1, moves + 1, state);
        } else if (state == 0) {
            if (leaves.charAt(index) == 'r') {
                // dont change
                nextLeaf(leaves, index + 1, moves, state);
                // change to y, next state
                nextLeaf(leaves, index + 1, moves + 1, state + 1);
            } else {
                // change to r
                nextLeaf(leaves, index + 1, moves + 1, state);
                // dont change, next state
                nextLeaf(leaves, index + 1, moves, state + 1);
            }
        } else if (state == 1) {
            if (leaves.charAt(index) == 'r') {
                // change leaf to y
                nextLeaf(leaves, index + 1, moves + 1, state);
                // dont change, next state
                nextLeaf(leaves, index + 1, moves, state + 1);
            } else {
                // dont change
                nextLeaf(leaves, index + 1, moves, state);
                // change to next state
                nextLeaf(leaves, index + 1, moves + 1, state + 1);
            }
        } else if (state == 2) {
            if (leaves.charAt(index) == 'r')
                nextLeaf(leaves, index + 1, moves, state);
            else
                nextLeaf(leaves, index + 1, moves + 1, state);
        }

    }

    /***
     * dp
     * state:   0: r...
     *          1: r...ry...
     *          2: r...ry...yr...
     *
     *  dp[i][0] = dp[i-1][0] + leaves[i] is y
     *  dp[i][1] =  if leaves[i] is y: min{dp[i-1][0], dp[i-1][1]}
     *              if leaves[i] is r: min{dp[i-1][0] + 1, dp[i-1][1] + 1}
     *  dp[i][2] =  if leaves[i] is y: min{dp[i-1][1] + 1, dp[i-1][2] + 1}
     *              if leaves[i] is r: min{dp[i-1][1], dp[i-1][2]}
     *  find min moves in dp[:][2]
     */
    public int minimumOperationsDP(String leaves) {
        int[][] dp = new int[leaves.length()][3];
        dp[0][0] += leaves.charAt(0) == 'r' ? 0 : 1;
        dp[0][1] = Integer.MAX_VALUE - 100;
        dp[0][2] = Integer.MAX_VALUE - 100;

        for (int i = 1; i < leaves.length(); i++) {
            dp[i][0] = dp[i - 1][0] + ((leaves.charAt(i) == 'y') ? 1 : 0);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + ((leaves.charAt(i) == 'r') ? 1 : 0);
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + ((leaves.charAt(i) == 'y') ? 1 : 0);
        }
        
        return dp[leaves.length() - 1][2];
    }

    public int minimumOperations(String leaves) {
        nextLeaf(leaves, 0, 0, 0);
        return globalMove;
    }

    public static void main(String[] args) {
        FallLeavesCollection collection = new FallLeavesCollection();
        String leaves = "yry";
        System.out.println(collection.minimumOperationsDP(leaves));
    }
}
