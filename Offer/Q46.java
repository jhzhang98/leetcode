package Offer;

public class Q46 {
    int res = 0;

    public int translateNum(int num) {
        String str = "" + num;
        int n = str.length();
        boolean[][] legalNum = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            legalNum[i][i] = true;
            if (str.charAt(i) == '0')
                continue;
            for (int j = i + 1; j < n; j++) {
                legalNum[i][j] = legalNum[i][j - 1] && Integer.parseInt(str.substring(i, j + 1)) <= 25;
            }
        }

        dfs(str, 0, legalNum);
        return res;
    }

    private void dfs(String str, int index, boolean[][] legalNum) {
        if (index == str.length()) {
            res++;
            return;
        }

        for (int i = index; i < str.length(); i++) {
            if (legalNum[index][i])
                dfs(str, i + 1, legalNum);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q46().translateNum(12258));
    }
}
