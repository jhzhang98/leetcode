package Medium;

import java.util.Arrays;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] n1 = new int[len1], n2 = new int[len2];
        int[] res = new int[len1 + len2];
        Arrays.fill(res, -1);
        for (int i = 0; i < n1.length; i++)
            n1[i] = num1.charAt(i) - '0';
        for (int i = 0; i < n2.length; i++)
            n2[i] = num2.charAt(i) - '0';

        for (int i = len2 - 1; i >= 0; i--) {
            int writePos = res.length - (len2 - i);
            int count = 0;
            for (int j = len1 - 1; j >= 0; j--) {
                int tmpRes = n2[i] * n1[j] + count;
                if (tmpRes > 9) {
                    count = tmpRes / 10;
                    tmpRes = tmpRes % 10;
                } else
                    count = 0;
                if (res[writePos] == -1)
                    res[writePos] = tmpRes;
                else {
                    res[writePos] += tmpRes;
                    if (res[writePos] > 9) {
                        count += 1;
                        res[writePos] -= 10;
                    }
                }
                writePos--;
            }
            if (count != 0)
                res[writePos] = count;
        }
        StringBuilder sb = new StringBuilder();
        boolean start = true;
        for (int i = 0; i < res.length; i++) {
            int n = res[i];
            if (start && n == 0 && i != res.length - 1)
                continue;
            if (n >= 0) {
                start = false;
                sb.append((char) (n + '0'));
            }
        }
        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        MultiplyStrings strings = new MultiplyStrings();
        String num1 = "9999";
        String num2 = "0";
        System.out.println(strings.multiply(num1, num2));
    }
}
