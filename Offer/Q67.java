package Offer;

public class Q67 {
    public int strToInt(String str) {
        int sign = 1;
        int start = 0;
        while (start < str.length()) {
            char c = str.charAt(start);
            if (c >= '0' && c <= '9')
                break;
            else if (c == '-') {
                sign = -1;
                start++;
                break;
            } else if (c != ' ') {
                return 0;
            }
            start++;
        }

        int end = str.length() - 1;
        while (end >= 0) {
            char c = str.charAt(end);
            if (c >= '0' && c <= '9')
                break;
            end--;
        }

        if (end < start) return 0;

        long res = 0;
        for (int i = start; i <= end; i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                res *= 10;
                res += (c - '0');
                if ((sign > 0 && res > Integer.MAX_VALUE - 1) ||
                        (sign < 0 && res > Integer.MAX_VALUE)) {
                    if (sign < 0)
                        return Integer.MIN_VALUE;
                    return Integer.MAX_VALUE;
                }
            } else return sign * (int) res;
        }

        return sign * (int) res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE + " " + Integer.MAX_VALUE);
        System.out.println(new Q67().strToInt("2147483648"));
    }
}
