package biweekly.w47;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q4 {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] d = new int[n];
        for (int[] edge : edges) {
            edge[0]--;
            edge[1]--;
            d[edge[0]]++;
            d[edge[1]]++;
        }
        int[] v = new int[n];
        System.arraycopy(d, 0, v, 0, n);
        Arrays.sort(v);
        int mask = 0x7FFF;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int[] edge : edges) {
            if (edge[0] > edge[1]) {
                int tmp = edge[0];
                edge[0] = edge[1];
                edge[1] = tmp;
            }
            int key = ((edge[0] & mask) << 15) + (edge[1] & mask);
            if (cnt.containsKey(key))
                cnt.put(key, cnt.get(key) + 1);
            else
                cnt.put(key, 1);
        }

        int[] res = new int[queries.length];
        for (int k = 0; k < queries.length; k++) {
            int query = queries[k];
            int sum = 0;
            for (int i = 0, j = n - 1; i < n; i++) {
                while (j >= 0 && v[i] + v[j] > query)
                    j--;
                sum += (n - j - 1);
            }

            for (int i = 0; i < n; i++) {
                if (v[i] + v[i] > query)
                    sum -= 1;
            }
            sum /= 2;

            for (int key : cnt.keySet()) {
                int[] edge = new int[]{(key >> 15) & mask, key & mask};
                if (d[edge[0]] + d[edge[1]] > query && d[edge[0]] + d[edge[1]] - cnt.get(key) <= query)
                    sum--;
            }

            res[k] = sum;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{1, 2}, {2, 4}, {1, 3}, {2, 3}, {2, 1}};
        int[] queries = {2, 3};
        System.out.println(Arrays.toString(new Q4().countPairs(n, edges, queries)));
    }
}
