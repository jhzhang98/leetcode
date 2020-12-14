package Medium;

import java.util.*;

public class ReconstructOriginalDigitsFromEnglish {
    public String originalDigits(String s) {
        List<Integer> res = new ArrayList<>();
        int[] nums = new int[26];
        for (char c : s.toCharArray())
            nums[c - 'a']++;
        int remainedLen = s.length();
        while (remainedLen != 0) {
            if (nums['z' - 'a'] > 0) {
                res.add(0);
                nums['z' - 'a']--;
                nums['e' - 'a']--;
                nums['r' - 'a']--;
                nums['o' - 'a']--;
                remainedLen -= 4;
            } else if (nums['w' - 'a'] > 0) {
                res.add(2);
                nums['t' - 'a']--;
                nums['w' - 'a']--;
                nums['o' - 'a']--;
                remainedLen -= 3;
            } else if (nums['u' - 'a'] > 0) {
                res.add(4);
                nums['f' - 'a']--;
                nums['o' - 'a']--;
                nums['u' - 'a']--;
                nums['r' - 'a']--;
                remainedLen -= 4;
            } else if (nums['x' - 'a'] > 0) {
                res.add(6);
                nums['s' - 'a']--;
                nums['i' - 'a']--;
                nums['x' - 'a']--;
                remainedLen -= 3;
            } else if (nums['g' - 'a'] > 0) {
                res.add(8);
                nums['e' - 'a']--;
                nums['i' - 'a']--;
                nums['g' - 'a']--;
                nums['h' - 'a']--;
                nums['t' - 'a']--;
                remainedLen -= 5;
            } else if (nums['s' - 'a'] > 0) {
                res.add(7);
                nums['s' - 'a']--;
                nums['e' - 'a']--;
                nums['v' - 'a']--;
                nums['e' - 'a']--;
                nums['n' - 'a']--;
                remainedLen -= 5;
            } else if (nums['f' - 'a'] > 0) {
                res.add(5);
                nums['f' - 'a']--;
                nums['i' - 'a']--;
                nums['v' - 'a']--;
                nums['e' - 'a']--;
                remainedLen -= 4;
            } else if (nums['t' - 'a'] > 0) {
                res.add(3);
                nums['t' - 'a']--;
                nums['h' - 'a']--;
                nums['r' - 'a']--;
                nums['e' - 'a'] -= 2;
                remainedLen -= 5;
            } else if (nums['o' - 'a'] > 0) {
                res.add(1);
                nums['o' - 'a']--;
                nums['n' - 'a']--;
                nums['e' - 'a']--;
                remainedLen -= 3;
            } else {
                res.add(9);
                nums['n' - 'a']--;
                nums['i' - 'a']--;
                nums['n' - 'a']--;
                nums['e' - 'a']--;
                remainedLen -= 4;
            }
        }
        res.sort(Integer::compare);
        StringBuilder str = new StringBuilder();
        for (int num : res)
            str.append(num);
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(-1e16);
        ReconstructOriginalDigitsFromEnglish english = new ReconstructOriginalDigitsFromEnglish();
        String str = "eighotnineozneonetewothreefourfivesixrseven";
        System.out.println(english.originalDigits(str));
    }
}
