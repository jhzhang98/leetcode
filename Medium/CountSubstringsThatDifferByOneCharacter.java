package Medium;

public class CountSubstringsThatDifferByOneCharacter {

    private boolean oneDiffEquals(String s, int sStart, String t, int tStart, int len) {
        int diff = 0;
        for (int i = 0; i < len; i++) {
            boolean different = (s.charAt(i + sStart) != t.charAt(i + tStart));
            if (diff == 0 && different)
                diff++;
            else if (diff != 0 && different)
                return false;
        }
        return diff == 1;
    }

    private int checkLengthSubStr(int len, String s, String t) {
        int count = 0;
        for (int sStart = 0; sStart + len <= s.length(); sStart++) {
            for (int tStart = 0; tStart + len <= t.length(); tStart++) {
                if (oneDiffEquals(s, sStart, t, tStart, len))
                    count++;
            }
        }
        return count;
    }

    public int countSubstrings(String s, String t) {
        int count = 0;
        for (int i = 1; i <= s.length(); i++) {
            count += checkLengthSubStr(i, s, t);
        }
        return count;
    }

    public static void main(String[] args) {
        CountSubstringsThatDifferByOneCharacter character = new CountSubstringsThatDifferByOneCharacter();
        String s = "ab";
        String t = "bb";
        System.out.println(character.countSubstrings(s, t));
    }
}
