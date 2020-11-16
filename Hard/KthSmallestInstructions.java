package Hard;

public class KthSmallestInstructions {
    int count = 0;
    String path;

    private void dfs(int[] dest, int[] cur, int k, String path) {
        if (dest[0] == cur[0] && dest[1] == cur[1]) {
            count++;
            if (count == k) {
                this.path = path;
                return;
            }
            if (count > k)
                return;
        }
        if (cur[1] < dest[1])
            dfs(dest, new int[]{cur[0], cur[1] + 1}, k, path + "H");
        if (cur[0] < dest[0])
            dfs(dest, new int[]{cur[0] + 1, cur[1]}, k, path + "V");
    }

    public String kthSmallestPath(int[] destination, int k) {
        dfs(destination, new int[]{0, 0}, k, "");
        return path;
    }

    public static void main(String[] args) {
        KthSmallestInstructions instructions = new KthSmallestInstructions();
        int[] dest = {2, 3};
        int k = 3;
        System.out.println(instructions.kthSmallestPath(dest, k));
    }
}
