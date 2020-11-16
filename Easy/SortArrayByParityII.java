package Easy;

public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int[] odd = new int[A.length / 2];
        int[] even = new int[A.length / 2];
        int index1 = 0, index2 = 0;
        for (int j : A) {
            if (j % 2 != 0)
                odd[index1++] = j;
            else
                even[index2++] = j;
        }
        for (int i = 0; i < A.length; i += 2)
            A[i] = even[i / 2];
        for (int i = 1; i < A.length; i += 2)
            A[i] = odd[i / 2];
        return A;
    }
}
