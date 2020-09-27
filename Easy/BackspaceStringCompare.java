package Easy;

public class BackspaceStringCompare {

    private int numOfBackSpaceFromRight(String str) {
        int count = 0;
        for (int i = str.length() - 1; i >= 0; i--) { // 找末尾有几个#
            if (str.charAt(i) == '#')
                count++;
            else
                break;
        }
        return count;
    }

    public boolean backspaceCompare(String S, String T) {
        if (S.length() == 0 && T.length() == 0) {
            return true;
        } else if (T.length() != 0 && S.length() == 0) {
            if (T.charAt(T.length() - 1) != '#')
                return false;
        } else if (S.length() != 0 && T.length() == 0) {
            if (S.charAt(S.length() - 1) != '#')
                return false;
        } else if (S.length() > 0 && T.length() > 0 && S.charAt(S.length() - 1) != '#' && T.charAt(T.length() - 1) != '#') {
            if (S.charAt(S.length() - 1) != T.charAt(T.length() - 1))
                return false;
            else
                return backspaceCompare(S.substring(0, S.length() - 1), T.substring(0, T.length() - 1));
        }
        int SBack = numOfBackSpaceFromRight(S);
        int TBack = numOfBackSpaceFromRight(T);
        int SIndex = S.length() - 1 - SBack;
        int TIndex = T.length() - 1 - TBack;
        while (SBack > 0) {
            if (SIndex < 0)
                break;
            if (S.charAt(SIndex) != '#')
                SBack--;
            else
                SBack++;
            SIndex--;
        }
        while (TBack > 0) {
            if (TIndex < 0)
                break;
            if (T.charAt(TIndex) != '#')
                TBack--;
            else
                TBack++;
            TIndex--;
        }
        if (SIndex < 0 && TIndex >= 0) {
            return backspaceCompare("", T.substring(0, TIndex + 1));
        } else if (SIndex >= 0 && TIndex < 0) {
            return backspaceCompare(S.substring(0, SIndex + 1), "");
        } else if (SIndex >= 0 && TIndex >= 0) {
            return backspaceCompare(S.substring(0, SIndex + 1), T.substring(0, TIndex + 1));
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        BackspaceStringCompare compare = new BackspaceStringCompare();
        String S = "bxj##";
        String T = "bxj###";
        System.out.println(compare.backspaceCompare(S, T));
    }

}
