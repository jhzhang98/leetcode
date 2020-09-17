package Hard;

import java.util.*;

public class RedundantConnectionII {

    private Set<Integer> checkCircle(int[][] edges, Map<Integer, Point> points) {
        // 假设存在环，随便删一条环的边
        Map<Integer, List<Integer>> findParent = new HashMap<>();
        Map<Integer, List<Integer>> findChildren = new HashMap<>();
        for (int[] edge : edges) {
            if (findChildren.containsKey(edge[0]))
                findChildren.get(edge[0]).add(edge[1]);
            else {
                List<Integer> lst = new ArrayList<>();
                lst.add(edge[1]);
                findChildren.put(edge[0], lst);
            }
            if (findParent.containsKey(edge[1]))
                findParent.get(edge[1]).add(edge[0]);
            else {
                List<Integer> lst = new ArrayList<>();
                lst.add(edge[0]);
                findParent.put(edge[1], lst);
            }
        }

        // 开始删，删除一定不在环路上的节点，即出度为0
        int[] keyValue = points.keySet().stream().mapToInt(Integer::valueOf).toArray();
        Set<Integer> delete = new HashSet<>();
        for (int i = 0; i < keyValue.length; i++) {
            int key = keyValue[i];
            if (delete.contains(key))       // 如果被删掉了，看下一个
                continue;
            Point point = points.get(key);
            if (point.outDegree == 0 || point.inDegree == 0) {     // 找到根节点，搞他
                delete.add(key);            // 删掉他
                List<Integer> parents = new ArrayList<>(), children = new ArrayList<>();
                if (findParent.containsKey(key))
                    parents = findParent.get(key);
                else if (findChildren.containsKey(key))
                    children = findChildren.get(key);
                else
                    continue;
                for (int val : parents)          // 减少它父节点的出度
                    points.get(val).outDegree--;
                for (int val : children)         // 减少子节点的入度
                    points.get(val).inDegree--;
                i = -1;
            }
        }

        return delete;
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        Map<Integer, Point> points = new HashMap<>();
        for (int[] edge : edges) {
            if (points.containsKey(edge[0])) {
                points.get(edge[0]).outDegree++;
                points.get(edge[0]).outDegreeSave++;
            } else
                points.put(edge[0], new Point(0, 1));
            if (points.containsKey(edge[1])) {
                points.get(edge[1]).inDegree++;
                points.get(edge[1]).inDegreeSave++;
            } else
                points.put(edge[1], new Point(1, 0));
        }

        Set<Integer> delete = checkCircle(edges, points);
        Set<Integer> remained = new HashSet<>(points.keySet());
        remained.removeAll(delete);
        if (delete.size() != points.keySet().size()) {
            // 去除delete中的点后剩下的点就都是在环中的了
            for (int i = edges.length - 1; i >= 0; i--) {
                int[] edge = edges[i];
                if (delete.contains(edge[0]) || delete.contains(edge[1]))
                    continue;
                // 找到一个在环中的边，判断环中所有节点入度是否还会为2
                boolean continueFlag = false;
                for (int val : remained) {
                    int inDegree = points.get(val).inDegreeSave;
                    if (val == edge[1])
                        inDegree--;
                    if (inDegree >= 2) {
                        continueFlag = true;
                        break;
                    }
                }
                if (continueFlag) continue;
                return edge;
            }
        }

        // 非环，删掉入度等于2的节点的一条边即可
        int redundantInt = -1;
        for (int key : points.keySet()) {
            Point point = points.get(key);
            if (point.inDegreeSave > 1) {
                redundantInt = key;
                break;
            }
        }

        for (int i = edges.length - 1; i > -1; i--) {
            int[] edge = edges[i];
            if (edge[1] != redundantInt)
                continue;
            int value = edge[0];
            Point point = points.get(value);
            if (point.inDegreeSave + point.outDegreeSave == 1)
                continue;
            return edge;
        }

        return null;
    }

    public static void main(String[] args) {
        RedundantConnectionII redundant = new RedundantConnectionII();
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
//        int[][] edges = {{4, 2}, {1, 5}, {5, 2}, {5, 3}, {2, 4}};
//        int[][] edges = {{2, 1}, {3, 1}, {4, 2}, {1, 4}};
//        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println(Arrays.toString(redundant.findRedundantDirectedConnection(edges)));

    }
}

class Point {
    int inDegree;
    int outDegree;
    int outDegreeSave;
    int inDegreeSave;

    public Point(int inDegree, int outDegree) {
        this.inDegree = inDegree;
        this.outDegree = outDegree;
        this.outDegreeSave = outDegree;
        this.inDegreeSave = inDegree;
    }

    public String toString() {
        return "<" + inDegreeSave + "(" + inDegree+"), " + outDegreeSave + "(" + outDegree + ")" + " >";
    }
}