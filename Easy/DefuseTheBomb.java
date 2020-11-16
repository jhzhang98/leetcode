package Easy;

public class DefuseTheBomb {
    public int[] decrypt(int[] code, int k) {
        if (k == 0)
            return new int[code.length];
        int[] newCode = new int[code.length + code.length];
        System.arraycopy(code, 0, newCode, 0, code.length);
        System.arraycopy(code, 0, newCode, code.length, code.length);
        if (k > 0) {
            for (int i = 0; i < code.length; i++) {
                int sum = 0;
                for (int j = i + 1; j < i + 1 + k; j++)
                    sum += newCode[j];
                code[i] = sum;
            }
        } else {
            for (int i = 0; i < code.length; i++) {
                int sum = 0;
                for (int j = code.length + i - 1; j > code.length - 1 + k; j--)
                    sum += newCode[j];
                code[i] = sum;
            }
        }
        return code;
    }

    public static void main(String[] args) {

    }
}
