package Medium;

public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int[] save = new int[k + k];
        for (int i = 0; i < k; i++)
            save[i] = cardPoints[cardPoints.length - k + i];
        for (int i = k; i < 2 * k; i++)
            save[i] = cardPoints[i - k];
        int window = 0;
        for (int i = 0; i < k; i++)
            window += save[i];
        int res = window;
        for (int i = 0; i < save.length - k; i++) {
            window = window - save[i] + save[i + k];
            res = Math.max(window, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println(new MaximumPointsYouCanObtainFromCards().maxScore(cardPoints, k));
    }
}
