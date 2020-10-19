package Medium;

import java.util.*;

public class LexicographicallySmallestStringAfterApplyingOperations {
    Set<String> searched = new HashSet<>();

    /***
     * 会超时
     */
    public String findLexSmallestStringTimeOut(String s, int a, int b) {
        searched.add(s);
        String res = s;
        String tmp = s;
        while (true) {
            // 1. 轮转
            tmp = rotate(tmp, b);
            res = smallest(res, tmp);
            if (searched.contains(tmp))
                break;
            searched.add(tmp);
            while (true) {
                tmp = add(tmp, a);
                res = smallest(res, tmp);
                if (searched.contains(tmp))
                    break;
                searched.add(tmp);
                res = smallest(findLexSmallestStringTimeOut(tmp, a, b), res);
            }
        }
        return res;
    }

    private String smallest(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) > b.charAt(i))
                return b;
            else if (b.charAt(i) > a.charAt(i))
                return a;
        }
        return a;
    }

    private String rotate(String str, int b) {
        char[] s = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            s[(i + b) % str.length()] = str.charAt(i);
        }
        return String.valueOf(s);
    }

    private String add(String str, int a) {
        char[] s = str.toCharArray();
        for (int i = 1; i < str.length(); i += 2) {
            int dis = ((str.charAt(i) - '0' + a) % 10);
            s[i] = (char) ('0' + dis);
        }
        return String.valueOf(s);
    }

    /***
     * 结果甚至bfs暴力广搜就行
     * 先加，加到重复就轮转
     */
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> searched = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        String res = s;
        queue.add(s);
        while (!queue.isEmpty()) {
            String tmp = queue.poll();
            res = smallest(res, tmp);

            while (true) {
                String addStr = add(tmp, a);
                if (searched.contains(addStr))
                    break;
                searched.add(addStr);
                queue.add(addStr);
            }

            tmp = rotate(tmp, b);
            if (searched.contains(tmp))
                continue;
            searched.add(tmp);
            queue.add(tmp);
        }
        return res;
    }


    public static void main(String[] args) {
        LexicographicallySmallestStringAfterApplyingOperations operations = new LexicographicallySmallestStringAfterApplyingOperations();
        String s = "43987654";
        int a = 7, b = 3;
        System.out.println(operations.findLexSmallestString(s, a, b));
    }
}
