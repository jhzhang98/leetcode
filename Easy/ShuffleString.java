package Easy;

public class ShuffleString {
    public String restoreString(String s, int[] indices) {
        char[] res = new char[s.length()];
        for (int i=0 ; i<indices.length ; i++){
            res[indices[i]] = s.charAt(i);
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        System.out.println(new ShuffleString().restoreString("codeleet", new int[]{4,5,6,7,0,2,1,3}));
    }
}
