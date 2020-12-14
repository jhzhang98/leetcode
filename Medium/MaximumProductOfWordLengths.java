package Medium;

public class MaximumProductOfWordLengths {
    private int getMask(String word, int[] masks) {
        int res = 0;
        for (char c : word.toCharArray())
            res = res | masks[c - 'a'];
        return res;
    }

    private int[] initMask() {
        int[] masks = new int[26];
        for (int i = 0; i < 26; i++) {
            int mask = 1;
            for (int j = 0; j < i; j++)
                mask <<= 1;
            masks[i] = mask;
        }
        return masks;
    }

    public int maxProduct(String[] words) {
        int[] masks = initMask();
        int[] wordMask = new int[words.length];
        for (int i = 0; i < words.length; i++)
            wordMask[i] = getMask(words[i], masks);
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((wordMask[i] & wordMask[j]) == 0)
                    res = Math.max(res, words[i].length() * words[j].length());
            }
        }
        return res;
    }
}
