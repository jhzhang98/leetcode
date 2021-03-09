package Hard;

public class CouplesHoldingHands {
    static class Union {
        int[] parent;
        int count;

        public Union(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
            count = n;
        }

        public int find(int x) {
            if (x == parent[x])
                return x;
            return find(parent[x]);
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py)
                return;
            parent[px] = py;
            count -= 1;
        }
    }

    public int minSwapsCouples(int[] row) {
        int n = row.length;
        Union union = new Union(n / 2);
        for (int i = 0; i < n ; i += 2)
            union.union(row[i] / 2, row[i + 1] / 2);
        return n / 2 - union.count;
    }

    public static void main(String[] args) {
        int[] row = {0,2,4,6,7,1,3,5};
        System.out.println(new CouplesHoldingHands().minSwapsCouples(row));
    }
}
