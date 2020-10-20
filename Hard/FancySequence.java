package Hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FancySequence {
    public static void main(String[] args) {
        Fancy fancy = new Fancy();
        fancy.append(2);   // 奇妙序列：[2]
        fancy.addAll(3);   // 奇妙序列：[2+3] -> [5]
        fancy.append(7);   // 奇妙序列：[5, 7]
        fancy.multAll(2);  // 奇妙序列：[5*2, 7*2] -> [10, 14]
        System.out.println(fancy.getIndex(0)); // 返回 10
        fancy.addAll(3);   // 奇妙序列：[10+3, 14+3] -> [13, 17]
        fancy.append(10);  // 奇妙序列：[13, 17, 10]
        fancy.multAll(2);  // 奇妙序列：[13*2, 17*2, 10*2] -> [26, 34, 20]
        System.out.println(fancy.getIndex(0)); // 返回 26
        System.out.println(fancy.getIndex(1)); // 返回 34
        System.out.println(fancy.getIndex(2)); // 返回 20
    }
}

class Fancy {
    List<Long> num;

    public Fancy() {
        num = new LinkedList<>();
    }

    public void append(int val) {
        num.add((long) val);
    }

    public void addAll(int inc) {
        for (int i=0 ; i<num.size() ; i++)
            num.set(i, (num.get(i) + inc) % 1000000007);
    }

    public void multAll(int m) {
        for (int i=0 ; i<num.size() ; i++)
            num.set(i, (num.get(i) * m) % 1000000007);
    }

    public int getIndex(int idx) {
        if (idx < num.size())
            return (int) (num.get(idx) % 1000000007);
        else
            return -1;
    }
}