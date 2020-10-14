package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        int[][] tag = new int[26][A.length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[i].length(); j++)
                tag[A[i].charAt(j) - 'a'][i]++;
        List<String> res = new ArrayList<>();
        if(A.length == 0)
            return res;
        for (int i = 0; i < tag.length; i++) {
            int common = Arrays.stream(tag[i]).min().getAsInt();
            if (common != 0) {
                char c = (char) ('a' + i);
                while (common-- != 0) {
                    res.add(String.valueOf(c));
                }
            }
        }
        return res;
    }
}
