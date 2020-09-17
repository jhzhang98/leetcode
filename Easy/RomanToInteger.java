package Easy;

import Medium.IntegerToRoman;

public class RomanToInteger {
    public int romanToInt(String s) {
        int[] integer = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int currentNum = 0;
        int biggestPart = 0;
        while(s.length() != 0){
            if(s.startsWith(roman[biggestPart])){
                s = s.substring(roman[biggestPart].length());
                currentNum += integer[biggestPart];
            }else
                biggestPart += 1;
        }
        return currentNum;
    }

    public static void main(String[] args) {
        RomanToInteger rti = new RomanToInteger();
        IntegerToRoman itr = new IntegerToRoman();
        for (int i=0 ; i<=3999; i++){
            String s = itr.intToRoman(i);
            int res = rti.romanToInt(s);
            if (res != i) {
                System.out.println(res);
                System.exit(-1);
            }
        }
    }
}
