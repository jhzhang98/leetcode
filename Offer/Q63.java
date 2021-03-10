package Offer;

import java.util.Arrays;

public class Q63 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0;
        int minCost = prices[0];
        int maxProfit = 0;
        for (int i=1 ; i<prices.length; i++){
            maxProfit = Math.max(maxProfit, prices[i] - minCost);
            minCost = Math.min(minCost, prices[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new Q63().maxProfit(prices));
    }
}
