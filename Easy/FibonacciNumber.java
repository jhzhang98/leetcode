package Easy;

public class FibonacciNumber {
    public int fib(int n) {
        double partA = (1 + Math.sqrt(5)) / 2;
        double partB = (1 - Math.sqrt(5)) / 2;
        return (int) Math.round(1 / Math.sqrt(5) * (Math.pow(partA, n) - Math.pow(partB, n)));
    }
}
