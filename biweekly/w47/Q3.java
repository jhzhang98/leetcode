package biweekly.w47;

public class Q3 {
    public int beautySum(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int[] cnt = new int[26];
            int[] maxArray = new int[n];
            maxArray[i] = 1;
            int maxCnt = 1;
            cnt[s.charAt(i) - 'a']++;
            for (int j = i + 1; j < n; j++) {
                char c = s.charAt(j);
                cnt[c - 'a']++;
                maxCnt = Math.max(maxCnt, cnt[c - 'a']);
                maxArray[j] = maxCnt;
            }

            int minCnt = Integer.MAX_VALUE;
            for (int k = 0; k < 26; k++) {
                if (cnt[k] == 0)
                    continue;
                minCnt = Math.min(minCnt, cnt[k]);
            }

            res += maxArray[n - 1] - minCnt;
            for (int j = n - 1; j > i + 1; j--) {
                char c = s.charAt(j);
                cnt[c - 'a']--;
                if (cnt[c - 'a'] == 0) {
                    minCnt = Integer.MAX_VALUE;
                    for (int k = 0; k < 26; k++) {
                        if (cnt[k] == 0)
                            continue;
                        minCnt = Math.min(minCnt, cnt[k]);
                    }
                } else if (cnt[c - 'a'] < minCnt) {
                    minCnt = cnt[c - 'a'];
                }
                res += maxArray[j - 1] - minCnt;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "aaba";
        System.out.println(new Q3().beautySum(str));
    }
}
