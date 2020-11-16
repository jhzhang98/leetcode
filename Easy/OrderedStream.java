package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderedStream {
    String[] stream;
    int ptr;

    public OrderedStream(int n) {
        stream = new String[n + 1];
        Arrays.fill(stream, null);
        ptr = 0;
    }

    public List<String> insert(int id, String value) {
        stream[id - 1] = value;
        List<String> res = new ArrayList<>();
        while (ptr < stream.length + 1 && stream[ptr] != null) {
            res.add(stream[ptr++]);
        }
        return res;
    }

    public static void main(String[] args) {
        OrderedStream os =new OrderedStream(5);
        System.out.println(os.insert(3, "ccccc")); // 插入 (3, "ccccc")，返回 []
        System.out.println(os.insert(1, "aaaaa")); // 插入 (1, "aaaaa")，返回 ["aaaaa"]
        System.out.println(os.insert(2, "bbbbb")); // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
        System.out.println(os.insert(5, "eeeee")); // 插入 (5, "eeeee")，返回 []
        System.out.println(os.insert(4, "ddddd")); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
    }
}
