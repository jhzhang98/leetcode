package weekly.w233;

public class Q3 {
    private long curSum(int n, int index, int k) {
        long sum = k;
        if (index >= k - 1)
            sum += ((long) k * (k - 1)) / 2 + (index - k + 1);
        else
            sum += ((long) k - 1 + k - index) * index / 2;
        if (n - index - 1 >= k - 1)
            sum += ((long) k * (k - 1)) / 2 + (n - index - k);
        else
            sum += ((long) k - 1 + k - (n - index - 1)) * (n - index - 1) / 2;
        return sum;
    }

    public int maxValue(int n, int index, int maxSum) {
        int left = 1, right = maxSum - n + 1;
        int res = 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            long curSum = curSum(n, index, mid);
            if (curSum <= maxSum) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 6;
        int index = 2;
        int maxSum = 931384943;
        System.out.println(new Q3().maxValue(n, index, maxSum));
    }
}
