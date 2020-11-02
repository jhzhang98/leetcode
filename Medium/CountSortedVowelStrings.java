package Medium;

import java.util.Arrays;

public class CountSortedVowelStrings {
    public int countVowelStrings(int n) {
        int[][] save = new int[n][5];
        for (int i = 0; i < 5; i++)
            save[0][i] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                int sum = 0;
                for (int k = j; k < 5; k++)
                    sum += save[i - 1][k];
                save[i][j] = sum;
            }
        }
        return Arrays.stream(save[n - 1]).sum();
    }

    public static void main(String[] args) {
        CountSortedVowelStrings strings = new CountSortedVowelStrings();
        System.out.println(strings.countVowelStrings(5));
    }
}
