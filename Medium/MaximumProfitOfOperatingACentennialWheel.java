package Medium;

public class MaximumProfitOfOperatingACentennialWheel {

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int maxProfit = -1;
        int curProfit = 0;
        int cusRemained = 0;
        int waveNum = 0;
        int maxProfitWave = -1;
        do {
            if (waveNum < customers.length)
                cusRemained += customers[waveNum];
            int cusServe = Math.min(cusRemained, 4);
            cusRemained -= cusServe;
            curProfit += cusServe * boardingCost - runningCost;
            if (maxProfit < curProfit) {
                maxProfitWave = waveNum;
                maxProfit = curProfit;
            }
            maxProfit = Math.max(maxProfit, curProfit);
            waveNum++;
        } while (cusRemained != 0 || waveNum < customers.length);
        return maxProfitWave == -1 ? -1 : maxProfitWave + 1;
    }

    public static void main(String[] args) {
        MaximumProfitOfOperatingACentennialWheel wheel = new MaximumProfitOfOperatingACentennialWheel();
        int[] customers = {10,10,6,4,7};
        int boardingCost = 3, runningCost = 8;
        System.out.println(wheel.minOperationsMaxProfit(customers, boardingCost, runningCost));
    }
}
