package Offer;

import java.util.Arrays;

public class Q58I {
    public String reverseWords(String s) {
        String[] strs = s.split("[ ]");
        String res = "";
        for (int i = strs.length - 1; i >= 0; i--) {
            String str = strs[i];
            if (str.length() == 0)
                continue;
            res += str + " ";
        }
        return res.substring(0, res.length() - 1);
    }

    public static void main(String[] args) {
        String s = " hello!   world!  ";
        System.out.println(new Q58I().reverseWords(s));
    }
}
