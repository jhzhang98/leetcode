package weekly.w234;

import java.util.*;

public class Q3 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> dict : knowledge)
            map.put(dict.get(0), dict.get(1));

        List<String> save = new ArrayList<>();

        int left = 0, right = 0;
        while (right < s.length()) {
            if (s.charAt(left) == '(') {
                while (s.charAt(right) != ')')
                    right++;
                String key = s.substring(left + 1, right);
                save.add(map.getOrDefault(key, "?"));
                left = right + 1;
                right = left;
            } else {
                while (right < s.length() && s.charAt(right) != '(') right++;
                save.add(s.substring(left, right));
                left = right;
            }
        }

        StringBuilder res = new StringBuilder();
        for (String val : save)
            res.append(val);
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "(a)(a)(a)aaa";
        List<List<String>> knowledge = new ArrayList<>();
        knowledge.add(Arrays.asList("a", "yes"));
        System.out.println(new Q3().evaluate(s, knowledge));
    }
}
