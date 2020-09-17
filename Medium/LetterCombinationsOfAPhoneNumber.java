package Medium;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    /**
     * 计数器
     */
    private int[] nexCombination(int[] current, int[] maxChar) {
        int i = current.length - 1;
        // 如果末位没有满
        if (current[i] + 1 < maxChar[i]) {
            current[i] += 1;
            return current;
        } else { // 向前找，直到找到未满的
            for (int j = i - 1; j != -1; j--) {
                if (current[j] + 1 < maxChar[j]) { //如果找到，说明还有组合，该位加一，后位置零
                    current[j] += 1;
                    for (int k = j + 1; k < current.length; k++)
                        current[k] = 0;
                    return current;
                }
            }
            // 如果找遍，全部满了，说明计数器达到最大，返回null代表穷尽
            return null;
        }
    }

    public List<String> letterCombinations(String digits) {
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        List<String> res = new ArrayList<>();

        if (digits.length() == 0)
            return res;

        char[] inputDig = digits.toCharArray();
        int[] index = new int[digits.length()];
        int[] maxCharLen = new int[digits.length()];
        for (int i = 0; i < maxCharLen.length; i++)
            maxCharLen[i] = map.get(inputDig[i]).length;

        while (index != null) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < index.length; i++)
                str.append(map.get(inputDig[i])[index[i]]);
            res.add(str.toString());

            index = nexCombination(index, maxCharLen);
        }
        return res;
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber lcpn = new LetterCombinationsOfAPhoneNumber();
        String dig = "8";
        List<String> lst = lcpn.letterCombinations(dig);
        for (String str : lst)
            System.out.println(str);

//        int [] index = {0, 0};
//        while(index != null) {
//            index = lcpn.nexCombination(index);
//            System.out.println(Arrays.toString(index));
    }
}

