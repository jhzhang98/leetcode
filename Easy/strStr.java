package Easy;

public class strStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        for (int i=0 ; i<haystack.length() ; i++){
            char c = haystack.charAt(i);
            if (c == needle.charAt(0)){
                boolean equal = true;
                for (int j=1 ; j<needle.length() ; j++){
                    if (i + j >= haystack.length())
                        return -1;
                    if (needle.charAt(j) != haystack.charAt(i + j)){
                        equal = false;
                        break;
                    }
                }
                if (equal)
                    return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        strStr str = new strStr();
        String haystack = "";
        String needle = "";
        System.out.println(str.strStr(haystack, needle));
    }
}
