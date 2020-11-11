package Easy;

public class BestTimeToBuyAndSellStockII {
    private int footIndex(int[] prices, int start) {
        for (int i = start + 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                return i - 1;
        }
        return -1;
    }

    private int topIndex(int[] prices, int start) {
        int lastTop = start + 1;
        for (int i = start + 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1])
                lastTop = i;
            else
                return lastTop;
        }
        return lastTop;
    }

    /***
     * climb mountain, buy at foot, sell on the top
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length <= 1)
            return profit;

        int index = 0;
        while (index < prices.length) {
            // 1. find first foot of mountain
            int foot = footIndex(prices, index);
            if (foot == -1)
                return profit;
            // 2. find top of mountain
            int top = topIndex(prices, foot);
            profit += prices[top] - prices[foot];
            index = top + 1;
        }
        return profit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII stockII = new BestTimeToBuyAndSellStockII();
        int[] prices = {1,2};
        System.out.println(stockII.maxProfit(prices));
    }
}
