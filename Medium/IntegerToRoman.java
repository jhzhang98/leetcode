package Medium;

public class IntegerToRoman {
    public String intToRoman(int num) {
        int[] integer = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder res = new StringBuilder();

        int remain = num;
        int biggestPart = integer.length - 1;

        while (remain != 0) {
            if (remain - integer[biggestPart] >= 0) {
                remain -= integer[biggestPart];
                res.append(roman[biggestPart]);
            }else
                biggestPart -= 1;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman itr = new IntegerToRoman();
        int num = 3999;
        System.out.println(itr.intToRoman(num));
    }
}
