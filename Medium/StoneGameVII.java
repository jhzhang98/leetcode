package Medium;

public class StoneGameVII {
    public int stoneGameVII(int[] stones) {
        int[][] dp = new int[stones.length][stones.length];
        int[][] sum = new int[stones.length][stones.length];
        for (int i = 0; i < stones.length; i++) {
            sum[i][i] = stones[i];
            for (int j = i + 1; j < stones.length; j++) {
                sum[i][j] = sum[i][j - 1] + stones[j];
            }
        }

        for (int i = 2; i < dp.length; i++) {
            for (int j = i; j < dp.length; j++) {

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        StoneGameVII gameVII = new StoneGameVII();
        int[] stones = {721, 979, 690, 84, 742, 873, 31, 323, 819, 22, 928, 866, 118, 843, 169, 818, 908, 832, 852, 480, 763, 715, 875, 629};
//        int[] stones = {5,3,1,4,2};
//        int[] stones = {7,90,5,1,100,10,10,2};
        System.out.println(gameVII.stoneGameVII(stones));
    }
}
