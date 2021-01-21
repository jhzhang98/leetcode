package biweekly.w42;

public class Q2 {
    public double averageWaitingTime(int[][] customers) {
        if (customers.length == 0)
            return 0;
        long startTime = 0;
        long waitTime = 0;
        for (int[] customer : customers) {
            if (startTime > customer[0])
                waitTime += startTime - customer[0];
            startTime = Math.max(startTime, customer[0]);
            startTime += customer[1];
            waitTime += customer[1];
        }
        return waitTime * 1.0 / customers.length;
    }
}
