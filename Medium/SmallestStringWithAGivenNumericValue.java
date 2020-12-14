package Medium;

public class SmallestStringWithAGivenNumericValue {
    public String getSmallestString(int n, int k) {
        int[] res = new int[n];
        int remain = k;
        for (int i = 0; i < n; i++) {
            int sub = remain - (26 * (n - i - 1));
            if (sub <= 0) {
                res[i] = 1;
                remain -= 1;
            } else {
                res[i] = sub;
                remain -= sub;
            }
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++)
            str.append((char) ('a' + (res[i] - 1)));
        return str.toString();
    }

    public static void main(String[] args) {
        SmallestStringWithAGivenNumericValue value = new SmallestStringWithAGivenNumericValue();
        int n = 5, k = 73;
        System.out.println(value.getSmallestString(n, k));
    }
}
