package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegularExpressionMatching {

    private boolean matchesOneChar(String c, String p) {
        if (c.length() == 1) {   // 如果c是一个字符，p无论是一个长还是两个长，都只用看第一个符号
            if(p.charAt(0) == '.')
                return true;
            else
                return c.charAt(0) == p.charAt(0);
        }else if (c.length() == 0 ){    // 如果c是空串，直接看p是否有*
            return p.length() == 2;
        }

        return false;
    }

    // 一个正则符号一个正则符号匹配，对于.*或a*视为一个正则符号
    private void matchNext(String s, int sStart, int sEnd, String[] pSet, int pIndex, int[] pSetMatches) {
        while(true){
            String c = s.substring(sStart, sEnd);
            boolean matches = matchesOneChar(c, pSet[pIndex]);
            if (matches)

            if (c.length() == 0){

            }
        }
    }

    public boolean isMatch(String s, String p) {
        String[] pSet = initP(p);
        int[] pSetMatches = new int[pSet.length];   // 每个正则符号匹配了多少个元素
        matchNext(s, 0, 0, pSet, 0, pSetMatches);
        return true;
    }

    private String[] initP(String p) {
        List<String> pSet = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            if (i + 1 < p.length() && p.charAt(i + 1) == '*') {
                pSet.add(p.substring(i, i + 2));
                i++;
            } else
                pSet.add(p.substring(i, i + 1));
        }
        String[] res = new String[pSet.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = pSet.get(i);
        return res;
    }

    public static void main(String[] args) {
        RegularExpressionMatching matching = new RegularExpressionMatching();
        System.out.println(Arrays.toString(matching.initP("a.*.*abc*.")));
//        System.out.println("ac".substring(0, 0));
    }
}
