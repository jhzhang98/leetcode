package Easy;

public class ReverseString {
    public void reverseString(char[] s) {
        char save = 0;
        for (int i = 0; i < s.length / 2; i++) {
            save = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = save;
        }
    }

    public static void main(String[] args) {
        ReverseString string = new ReverseString();
        char[] s = "".toCharArray();
        string.reverseString(s);
        System.out.println(s);
    }
}
