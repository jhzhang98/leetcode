package Easy;

import java.util.*;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewels = new HashSet<>();
        for (char jewel : J.toCharArray())
            jewels.add(jewel);
        int count = 0;
        for (char jewel : S.toCharArray())
            if (jewels.contains(jewel))
                count++;
        return count;
    }

    public static void main(String[] args) {
        JewelsAndStones js = new JewelsAndStones();
        String J = "";
        String S = "";
        System.out.println(js.numJewelsInStones(J, S));
    }
}
