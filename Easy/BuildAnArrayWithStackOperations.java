package Easy;

import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOperations {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int targetIndex = 0;

        for (int i = 1; i <= n; i++) {
            if (targetIndex == target.length) {
                break;
            } else if (target[targetIndex] == i) {
                res.add("Push");
                targetIndex++;
            } else {
                res.add("Push");
                res.add("Pop");
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
