package tool;

public class Union {
    int n;
    int[] parent;

    public Union(int n) {
        this.n = n;
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    public void merge(int val1, int val2) {
        int p1 = find(val1), p2 = find(val2);
        if (p1 == p2) return;
        parent[p1] = p2;
    }

    public boolean connected(int val1, int val2) {
        return find(val1) == find(val2);
    }
}
