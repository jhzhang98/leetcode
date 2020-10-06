package Hard;

import java.util.*;

public class SumOfDistancesInTree {

    int distance = 0;

    private void dfs(int n, int parent, int depth, Set<Integer> searched, Map<Integer, List<Integer>> edges) {
        List<Integer> points = edges.get(n);
        boolean allChildrenSearched = true;
        for (int point : points) {
            if (point == parent)
                continue;
            if (!searched.contains(point)) {
                allChildrenSearched = false;
                break;
            }
        }
        if (allChildrenSearched) {
            searched.add(n);
        }else {
            for (int point : points) {
                if (point == parent || searched.contains(point))
                    continue;
                dfs(point, n, depth + 1, searched, edges);
            }
        }
        distance += depth;
    }


    /***
     * 利用DFS，对每个节点进行dfs搜索，每个节点都可以当作根节点进行搜索
     */
    public int[] sumOfDistancesInTreeDFS(int N, int[][] edges) {
        int[] res = new int[N];
        Map<Integer, List<Integer>> edgesMap = new HashMap<>();
        for (int[] edge : edges) {
            if (edgesMap.containsKey(edge[0])) {
                edgesMap.get(edge[0]).add(edge[1]);
            } else {
                List<Integer> ls = new ArrayList<>();
                ls.add(edge[1]);
                edgesMap.put(edge[0], ls);
            }
            if (edgesMap.containsKey(edge[1])) {
                edgesMap.get(edge[1]).add(edge[0]);
            } else {
                List<Integer> ls = new ArrayList<>();
                ls.add(edge[0]);
                edgesMap.put(edge[1], ls);
            }
        }

        for (int i = 0; i < N; i++) {
            distance = 0;
            dfs(i, -1, 0, new HashSet<>(), edgesMap);
            res[i] = distance;
        }
        return res;
    }

    /***
     * 超出内存限制，只好改成递归
     */
    private int dfsDis(int n, Map<Integer, List<Integer>> edges) {
        int dis = 0;
        Stack<Integer> stack = new Stack<>();
        Set<Integer> searched = new HashSet<>();
        Stack<Integer> parents = new Stack<>();
        Stack<Integer> depths = new Stack<>();
        stack.add(n);
        parents.add(-1);
        depths.add(0);
        searched.add(null);
        while (!stack.isEmpty()) {
            int node = stack.peek();
            int parent = parents.peek();
            List<Integer> jointedPoints = edges.get(node);
            boolean allChildrenSearched = true;
            for (int p : jointedPoints) {
                if (p == parent)
                    continue;
                if (!searched.contains(p)) {
                    allChildrenSearched = false;
                    break;
                }
            }
            if (allChildrenSearched) {
                stack.pop();
                parents.pop();
                dis += depths.pop();
                searched.add(node);
                continue;
            }
            int depth = depths.peek();
            for (int child : edges.get(node)) {
                if (!searched.contains(child) && !stack.contains(child)) {
                    stack.push(child);
                    depths.push(depth + 1);
                    parents.push(node);
                }
            }
        }
        return dis;
    }


    /***
     * d[i][j] = Min(d[i][k] + d[k][j]) for any k < N
     * 所以在迭代到d[i][j]时，查找d[j]行，对于每一个d[j][k]，更新d[i][k] = Min(d[i][k], d[i][j] + d[j][k])
     * 初始化时将d[i][i] = 0, 相邻边置为1
     * !!! 超出内存限制 !!!
     */
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int[][] dis = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                dis[i][j] = Integer.MAX_VALUE / 8;
        for (int i = 0; i < N; i++)
            dis[i][i] = 0;
        for (int[] edge : edges) {
            dis[edge[0]][edge[1]] = 1;
            dis[edge[1]][edge[0]] = 1;
        }

        for (int i = 0; i < N; i++) {
            boolean changedFlag = false;
            for (int j = 0; j < N; j++) {
                if (j == i || dis[i][j] == Integer.MAX_VALUE / 8)
                    continue;
                for (int k = 0; k < N; k++) {
                    if (k == i || k == j || dis[j][k] == Integer.MAX_VALUE / 8)
                        continue;
                    if (dis[i][j] + dis[j][k] < dis[i][k]) {
                        changedFlag = true;
                        dis[i][k] = dis[i][j] + dis[j][k];
                        dis[k][i] = dis[i][k];
                    }
                }
            }
            if (changedFlag) i--;
        }
        int[] res = new int[N];
        for (int i = 0; i < N; i++)
            res[i] = Arrays.stream(dis[i]).sum();
        return res;
    }

    public static void main(String[] args) {
        SumOfDistancesInTree tree = new SumOfDistancesInTree();
        int[][] edges = {{1, 3}, {5, 0}, {2, 5}, {6, 2}, {4, 2}, {6, 3}};
        int N = 7;
        System.out.println(Arrays.toString(tree.sumOfDistancesInTreeDFS(N, edges)));
    }
}
