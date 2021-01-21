package weekly.w221;

import java.util.Locale;

public class Q1 {
    public boolean halvesAreAlike(String s) {
        String str = s.toLowerCase();
        int index = str.length() / 2;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < index; i++) {
            char c = str.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                count1++;
        }
        for (int i = index; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                count2++;
        }
        return count1 == count2;
    }

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        System.out.println(q1.halvesAreAlike("tkPAdxpMfJiltOerItiv"));
    }
}
