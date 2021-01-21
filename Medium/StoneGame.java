package Medium;

public class StoneGame {
    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];
        for (int i = 0; i < piles.length; i++)
            dp[i][i] = piles[i];

        for (int k = 1; k < piles.length; k++) {
            for (int i = 0; i < piles.length; i++) {
                int j = i + k;
                if (j >= piles.length)
                    break;
                dp[i][j] = Math.max(-dp[i + 1][j] + piles[i], -dp[i][j - 1] + piles[j]);
            }
        }
        return dp[0][piles.length - 1] > 0;
    }

    public static void main(String[] args) {
        StoneGame game = new StoneGame();
        int[] piles = {5, 3, 4, 5};
        System.out.println(game.stoneGame(piles));
    }
}
