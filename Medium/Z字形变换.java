package Medium;

import java.util.*;

public class Z字形变换 {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i <= numRows; i++)
            map.add(new ArrayList<>());

        int x = 0, y = 0;
        boolean hill = false; // 判断是否为z的斜坡
        for (int i = 0; i < s.length(); i++) {
            map.get(x).add(i);
            if (!hill) {
                x++;
            } else {
                x--;
                y++;
            }
            if (x == 0)
                hill = false;
            else if (x == numRows - 1)
                hill = true;
        }

        StringBuilder result = new StringBuilder();
        for (List<Integer> lst : map) {
            for (int index : lst)
                result.append(s.charAt(index));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Z字形变换 test = new Z字形变换();
        String str = "LEETCODEISHIRING";
//        String str = "LEdf";
        int numRow = 2;
        System.out.println(test.convert(str, numRow));
    }
}
