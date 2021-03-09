package biweekly.w42;

public class Q3 {
    private int find(char[] bin, int index, char target) {
        for (int i = index; i >= 0; i--) {
            if (bin[i] == target)
                return i;
        }
        return -1;
    }

    public String maximumBinaryString(String binary) {
        char[] bin = binary.toCharArray();
        int oneStart = 0;
        for (; oneStart < bin.length; oneStart++) {
            if (bin[oneStart] == '0') {
                break;
            }
        }
        String start = binary.substring(0, oneStart);
        bin = binary.substring(oneStart).toCharArray();
        int zeroIndex = find(bin, bin.length - 1, '0');
        int oneIndex = find(bin, zeroIndex, '1');
        if (oneIndex < 0) {
            for (int i = 0; i < zeroIndex; i++)
                bin[i] = '1';
            return start + String.valueOf(bin);
        }
        bin[zeroIndex] = '1';
        bin[oneIndex] = '0';
        while (true) {
            zeroIndex = find(bin, zeroIndex, '0');
            oneIndex = find(bin, oneIndex, '1');
            if (zeroIndex < 0 || oneIndex < 0)
                break;
            bin[zeroIndex] = '1';
            bin[oneIndex] = '0';
        }
        zeroIndex = find(bin, zeroIndex, '0');

        for (int i = 0; i < zeroIndex; i++)
            bin[i] = '1';

        return start + String.valueOf(bin);
    }

    public static void main(String[] args) {
        Q3 q3 = new Q3();
        String binary = "0000";
        System.out.println(q3.maximumBinaryString(binary));
    }
}
