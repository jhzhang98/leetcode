package Easy;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        if (0 == strs.length)
            return res.toString();

        for (int i = 0; ; i++) {
            if (i > strs[0].length() - 1)
                return res.toString();
            char cur = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length())
                    return res.toString();
                if (strs[j].charAt(i) != cur)
                    return res.toString();
            }
            res.append(cur);
        }
    }

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"abd", "abc"};
        System.out.println(lcp.longestCommonPrefix(strs));
    }
}
