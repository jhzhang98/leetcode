package Medium;

public class 字符串转整数 {
    public int myAtoi(String str) {
        if (str.length() < 1)
            return 0;
        int index = 0, sign = 1;
        int start = 0, end = 0;
        // 1. 去空格
        while (index < str.length()) {
            char cur = str.charAt(index);
            if (cur == '-') {
                sign = -1;
                start = index++;
                break;
            } else if (cur == '+') {
                start = index++;
                break;
            } else if (cur >= '0' && cur <= '9') {
                start = index;
                break;
            } else if (cur != ' ')
                return 0;
            index++;
        }

        // 2. 去除0
        while (index < str.length()) {
            char cur = str.charAt(index);
            if (cur == '0')
                start = index++;
            else
                break;
        }

        // 3. 向后探
        while (index < str.length()) {
            char cur = str.charAt(index);
            if (cur <= '9' && cur >= '0')
                index++;
            else
                break;
        }
        if (str.charAt(index - 1) <= '9' && str.charAt(index - 1) >= '0')
            end = index;
        if (start >= end)
            return 0;

        if (end - start > 11)
            return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        long num = sign * Math.abs(Long.parseLong(str.substring(start, end)));
        return (num > Integer.MAX_VALUE) ? Integer.MAX_VALUE : (num < Integer.MIN_VALUE) ? Integer.MIN_VALUE : (int) num;
    }

    public static void main(String[] args) {
        字符串转整数 test = new 字符串转整数();
        String str = "200000000001";
        System.out.println(test.myAtoi(str));
    }
}
