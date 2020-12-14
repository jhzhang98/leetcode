package Hard;

public class SuperEggDrop {
    public int superEggDrop(int K, int N) {
        if (K == 1)
            return N;
        else if (N == 1)
            return 1;
        else if (N == 2)
            return 2;
        if (N % 2 == 1)
            return 1 + Math.max(superEggDrop(K - 1, N / 2 - 1), superEggDrop(K, N / 2));
        else
            return 1 + Math.max(superEggDrop(K - 1, N / 2 - 2), superEggDrop(K, N / 2 + 1));
    }

    public static void main(String[] args) {
        SuperEggDrop drop = new SuperEggDrop();
        int K = 3, N = 14;
        System.out.println(drop.superEggDrop(K, N));
    }
}
