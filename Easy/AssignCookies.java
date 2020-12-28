package Easy;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int childIndex = 0;
        int sizeIndex = 0;

        while (sizeIndex < s.length && childIndex < g.length) {
            if (s[sizeIndex] >= g[childIndex]) {
                sizeIndex++;
                childIndex++;
            } else {
                sizeIndex++;
            }
        }

        return childIndex;
    }

    public static void main(String[] args) {
        AssignCookies cookies = new AssignCookies();
        System.out.println(cookies.findContentChildren(new int[]{1, 2}, new int[]{1, 2}));
    }
}
