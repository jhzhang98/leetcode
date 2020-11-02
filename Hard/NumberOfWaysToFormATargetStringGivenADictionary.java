package Hard;

public class NumberOfWaysToFormATargetStringGivenADictionary {
    int tail = 1000000000 + 7;
    long res = 0;
    String[] words;
    char[] tarSet;

    private void search(int wordUsedLen, int tarIndex) {
        if (tarIndex == tarSet.length) {
            res = (res + 1) % tail;
            return;
        }
        int tarRemained = tarSet.length - tarIndex;
        for (int j = wordUsedLen+1; j <= words[0].length() - tarRemained; j++) {
            for (int i = 0; i < words.length; i++) {
                if (words[i].charAt(j) == tarSet[tarIndex])
                    search(j, tarIndex + 1);
            }
        }
    }

    public int numWays(String[] words, String target) {
        this.words = words;
        this.tarSet = target.toCharArray();
        search(-1, 0);
        return (int) res;
    }

    public static void main(String[] args) {

    }
}
