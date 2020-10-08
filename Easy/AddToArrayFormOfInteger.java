package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int index = 0;
        int count = 0;
        while (A.length - index - 1 >= 0) {
            if (K == 0 && count == 0)
                break;
            int tail = K % 10;
            K /= 10;
            int sum = A[A.length - index - 1] + tail + count;
            A[A.length - index - 1] = sum % 10;
            count = sum / 10;
            index++;
        }
        List<Integer> res = Arrays.stream(A).boxed().collect(Collectors.toList());
        if (K == 0) {
            if (count == 1)
                res.add(0, count);
        } else {
            K += count;
            while(K != 0){
                int tail = K % 10;
                K /= 10;
                res.add(0, tail);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        AddToArrayFormOfInteger integer = new AddToArrayFormOfInteger();
        int[] A = { 9, 9, 9};
        int K = 1;
        System.out.println(integer.addToArrayForm(A, K));
    }
}
