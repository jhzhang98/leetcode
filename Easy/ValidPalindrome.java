package Easy;

public class ValidPalindrome {
    private boolean meetLimitation(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    public boolean isPalindrome(String s) {
        if (s.length() == 0)
            return true;
        s = s.toUpperCase();
        char[] set = s.toCharArray();
        int pos = 0, end = 0;
        while (end < set.length) {
            if (meetLimitation(set[end]))
                set[pos++] = set[end];
            end++;
        }

        for (int i = 0; i < pos; i++) {
            if (set[i] != set[pos - i - 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome palindrome = new ValidPalindrome();
        String s = "";
        System.out.println(palindrome.isPalindrome(s));
    }
}
