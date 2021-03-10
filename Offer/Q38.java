package Offer;

import java.util.*;

public class Q38 {
    List<String> res = new ArrayList<>();
    int n;
    char[] charArray;

    private void dfs(String curStr, boolean[] used, int index) {
        if (index >= n) {
            res.add(curStr);
            return;
        }
        Set<Character> seek = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            char c = charArray[i];
            if (seek.contains(c))
                continue;
            seek.add(c);
            used[i] = true;
            dfs(curStr + c, used, index + 1);
            used[i] = false;
        }
    }

    public String[] permutation(String s) {
        this.charArray = s.toCharArray();
        this.n = s.length();
        boolean[] used = new boolean[s.length()];
        dfs("", used, 0);
        String[] res = new String[this.res.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = this.res.get(i);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q38().permutation("abcaa")));
        System.out.println(new Q38().permutation("abcaa").length);
    }
}
