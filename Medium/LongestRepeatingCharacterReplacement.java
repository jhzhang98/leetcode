package Medium;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int left = 0, right = -1;
        int maxLen = 0;
        int res = 0;
        int[] save = new int[26];
        while (++right < s.length()) {
            char c = s.charAt(right);
            save[c - 'A']++;
            maxLen = Math.max(maxLen, save[c - 'A']);
            if (right - left + 1 - maxLen > k) {
                save[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return Math.max(res, right - left);
    }

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement(s, k));
    }
}
