package Hard;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0)
            return 0;
        int n = prices.length;
        int m = Math.min(k + 1, n);
        int[][] dp_buy = new int[n][m];
        int[][] dp_sell = new int[n][m];

        for (int i = 1; i < m; i++) {
            dp_buy[0][i] = Integer.MIN_VALUE >> 1;
            dp_sell[0][i] = Integer.MIN_VALUE >> 1;
        }

        dp_buy[0][0] = -prices[0];
        dp_sell[0][0] = 0;

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            dp_buy[i][0] = Math.max(dp_buy[i-1][0], -prices[i]);
            for (int j = 1; j < m; j++) {
                dp_buy[i][j] = Math.max(dp_buy[i - 1][j], dp_sell[i - 1][j] - prices[i]);
                dp_sell[i][j] = Math.max(dp_sell[i - 1][j], dp_buy[i - 1][j - 1] + prices[i]);
                max = Math.max(Math.max(max, dp_buy[i][j]), dp_sell[i][j]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIV stockIV = new BestTimeToBuyAndSellStockIV();
        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(stockIV.maxProfit(k, prices));
    }
}
