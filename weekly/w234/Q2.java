package weekly.w234;

public class Q2 {
    public int reinitializePermutation(int n) {
        if (n == 2) return 1;
        int res = 1;
        int index = n / 2;
        int target = 1;
        while (index != target) {
            if (index % 2 == 0)
                index = index / 2;
            else
                index = n / 2 + (index - 1) / 2;
            res++;
        }
        return res;
    }
}
