package Easy;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        long sum = Integer.MIN_VALUE;
        for (int[] account : accounts) {
            long tmpSum = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                tmpSum += account[j];
            }
            sum = Math.max(sum, tmpSum);
        }
        return (int) sum;
    }
}
