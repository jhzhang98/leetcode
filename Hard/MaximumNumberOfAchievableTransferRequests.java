package Hard;

import java.util.*;

public class MaximumNumberOfAchievableTransferRequests {
    int maxNum;

    public int maximumRequests(int n, int[][] requests) {
        maxNum = n;
        int[] inDegree = new int[n];
        int[] outDegree = new int[n];
        Map<Integer, List<Integer>> getChildren = new HashMap<>();
        Map<Integer, List<Integer>> getParents = new HashMap<>();

        for (int i = 0; i < n; i++) {
            getChildren.put(i, new ArrayList<>());
            getParents.put(i, new ArrayList<>());
        }
        for (int[] request : requests) {
            getChildren.get(request[0]).add(request[1]);
            getParents.get(request[1]).add(request[0]);
            inDegree[request[1]]++;
            outDegree[request[0]]++;
        }
        check(inDegree, outDegree, n, getChildren, getParents);
        return maxNum;
    }

    private void check(int[] inDegree, int[] outDegree, int n, Map<Integer, List<Integer>> getChildren, Map<Integer, List<Integer>> getParents) {
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == outDegree[i])
                continue;
            if (inDegree[i] > outDegree[i]) {
                List<Integer> parents = getParents.get(i);
                maxNum--;
                Iterator<Integer> iterator = parents.iterator();
                while (iterator.hasNext()) {
                    int parent = iterator.next();
                    iterator.remove();
                    getChildren.get(parent).remove((Object) i);
                    check(inDegree, outDegree, n, getChildren, getParents);
                    parents.add(parent);
                    getChildren.get(parent).add(i);
                }
            } else {
                List<Integer> children = getChildren.get(i);
                maxNum--;
                Iterator<Integer> iterator = children.iterator();
                while (iterator.hasNext()) {
                    int child = iterator.next();
                    iterator.remove();
                    getParents.get(child).remove((Object) i);
                    check(inDegree, outDegree, n, getChildren, getParents);
                    children.add(child);
                    getParents.get(child).add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        MaximumNumberOfAchievableTransferRequests box = new MaximumNumberOfAchievableTransferRequests();
        int n = 5;
        int[][] requests = {{0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}};
        System.out.println(box.maximumRequests(n, requests));
    }
}
