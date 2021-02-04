package Hard;

public class CatAndMouse {
    int[][] graph;
    int n;

    public int catMouseGame(int[][] graph) {
        this.n = graph.length;
        this.graph = graph;
        // space[t][m][c] = mouse at m, cat at c, totally moved t steps
        int[][][] space = new int[2 * n][n][n];
        for (int i = 0; i < space.length; i++)
            for (int j = 0; j < space[0].length; j++)
                for (int k = 0; k < space[0][0].length; k++)
                    space[i][j][k] = -1;
        return move(space, 0, 1, 2);
    }

    private int move(int[][][] space, int step, int m, int c) {
        if (step == 2 * n) return 0;
        if (m == c) {
            space[step][m][c] = 2;
            return 2;
        }
        if (m == 0) {
            space[step][m][c] = 1;
            return 1;
        }

        if (space[step][m][c] != -1) // this state is searched, pass
            return space[step][m][c];

        if (step % 2 == 0) { // mouse move
            boolean catWin = true;
            for (int i = 0; i < graph[m].length; i++) {
                int nextMouse = graph[m][i];
                int nextState = move(space, step + 1, nextMouse, c);
                if (nextState == 1) {
                    space[step][m][c] = 1;
                    return 1;
                }
                if (nextState != 2) {
                    catWin = false; // if one state is draw, then cat can not win
                }
            }
            if (catWin) {
                space[step][m][c] = 2;
                return 2;
            }
            space[step][m][c] = 0;
            return 0;
        } else {
            boolean mouseWin = true;
            for (int i = 0; i < graph[c].length; i++) {
                int nextCat = graph[c][i];
                if (nextCat == 0)
                    continue;
                int nextState = move(space, step + 1, m, nextCat);
                if (nextState == 2) {
                    space[step][m][c] = 2;
                    return 2;
                } else if (nextState != 1) mouseWin = false; // if one state is draw, then mouse can not win
            }
            if (mouseWin) {
                space[step][m][c] = 1;
                return 1;
            }
            space[step][m][c] = 0;
            return 0;
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{5, 6}, {3, 4}, {6}, {1, 4, 5}, {1, 3, 5}, {0, 3, 4, 6}, {0, 2, 5}};
        System.out.println(new CatAndMouse().catMouseGame(graph));
    }
}
