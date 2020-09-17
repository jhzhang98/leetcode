package Easy;

public class 回文数 {
    public boolean isPalindrome(int x) {
        int reverse = Math.abs(x % 10);
        int num = Math.abs(x) / 10;

        while (num > 0) {
            reverse = reverse * 10 + num % 10;
            num /= 10;
        }

        return reverse == x;
    }

    public static void main(String[] args) {
        回文数 test = new 回文数();
        int x = 10;
        System.out.println(test.isPalindrome(x));
    }
}
