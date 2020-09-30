package Easy;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int profile = 0;
        for (int price : prices) {
            if (cost > price)
                cost = price;
            else if (price - cost > profile)
                profile = price - cost;
        }
        return profile;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock sellStock = new BestTimeToBuyAndSellStock();
        int[] prices = {6, 7};
        System.out.println(sellStock.maxProfit(prices));
    }
}
