package Easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PascalSTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        if (numRows == 0)
            return res;
        else {
            List<Integer> firstLine = new LinkedList<>(Collections.singletonList(1));
            res.add(firstLine);
        }
        for (int i = 1; i < numRows; i++) {
            List<Integer> line = new LinkedList<>();
            line.add(1);
            for (int j = 1; j < i; j++)
                line.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            line.add(1);
            res.add(line);
        }
        return res;
    }

    public static void main(String[] args) {
        PascalSTriangle pascalSTriangle = new PascalSTriangle();
        int numRows = 5;
        List<List<Integer>> res = pascalSTriangle.generate(numRows);
        for (int i = 0; i < numRows; i++)
            System.out.println(res.get(i));
    }
}
