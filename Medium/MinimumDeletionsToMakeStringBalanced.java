package Medium;

public class MinimumDeletionsToMakeStringBalanced {
    public int minimumDeletions(String s) {
        int[] dp_a = new int[s.length()];
        int[] dp_b = new int[s.length()];
        int[] dp_ab = new int[s.length()];
        dp_ab[0] = Integer.MAX_VALUE >> 3;
        if (s.charAt(0) == 'a') {
            dp_a[0] = 0;
            dp_b[0] = 1;
        } else {
            dp_a[0] = 1;
            dp_b[0] = 0;
        }

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'b') {
                dp_b[i] = dp_b[i - 1];
                dp_a[i] = dp_a[i - 1] + 1;
                dp_ab[i] = Math.min(dp_a[i - 1], dp_ab[i - 1]);
            } else if (c == 'a') {
                dp_b[i] = dp_b[i - 1] + 1;
                dp_a[i] = dp_a[i - 1];
                dp_ab[i] = dp_ab[i - 1] + 1;
            }
        }
        int min = Math.min(dp_a[s.length() - 1], dp_b[s.length() - 1]);
        min = Math.min(min, dp_ab[s.length() - 1]);
        return min;
    }

    public static void main(String[] args) {
        MinimumDeletionsToMakeStringBalanced balanced = new MinimumDeletionsToMakeStringBalanced();
        String s = "baaaa";
        System.out.println(balanced.minimumDeletions(s));
    }
}
