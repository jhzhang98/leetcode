package Easy;

public class 整数反转 {
    public int reverse(int x) {
        long result = Math.abs(x) % 10;
        int current = Math.abs(x) / 10;
        while (current != 0) {
            int tail = current % 10;
            current /= 10;
            result = result * 10 + tail;
        }
        result = x > 0 ? result : -result;
        return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? 0 : (int) result;
    }

    public static void main(String[] args) {
        整数反转 test = new 整数反转();
        int x = 1563847412;
        System.out.println(test.reverse(x));
    }
}
