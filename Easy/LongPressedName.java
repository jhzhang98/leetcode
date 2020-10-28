package Easy;

public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        if (typed.length() < name.length())
            return false;
        char pre = '-';
        int typedIndex = 0;
        for (int i = 0; i < name.length(); i++) {
            if(typedIndex >= typed.length())
                return false;
            if (pre == '-') {       // 如果是第一个字符
                if (name.charAt(0) != typed.charAt(0))
                    return false;
                pre = name.charAt(0);   // 更新上一个字符
            } else {
                if (name.charAt(i) == typed.charAt(typedIndex)) {   // 如果当前字符相同，都向下走一个
                    pre = name.charAt(i);
                } else {
                    if (typed.charAt(typedIndex) != pre)    // 如果不同，判断typed是否和pre相同
                        return false;
                    i--;           // name没有被比较，回退一
                }
            }
            typedIndex++;
        }

        while (typedIndex < typed.length() && typed.charAt(typedIndex) == pre)
            typedIndex++;
        return typedIndex == typed.length();
    }

    public static void main(String[] args) {
        LongPressedName pressedName = new LongPressedName();
        String name = "pyplrz";
        String typed = "ppyypllr";
        System.out.println(pressedName.isLongPressedName(name, typed));
    }
}
