package Easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        if (rowIndex == 1) return res;
        int index = 1;
        while(true){
            int tmp = (int) (((long) (res.get(index - 1)) * (rowIndex - index + 1)) / index);
            res.add(tmp);
            if (tmp == 1)
                break;
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new PascalsTriangleII().getRow(50));
    }
}
