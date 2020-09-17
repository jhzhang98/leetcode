package Medium;

public class 最长回文子串 {
    public String longestPalindrome(String s) {
        if (s.length() == 0)
            return s;
        String maxStr = "" + s.charAt(0);
        int left;
        int right;
        int lastCenter = 0;
        boolean checkTwoCenter = false;
        for (int currentCenter = 1; currentCenter < s.length(); currentCenter++) {
            if (!checkTwoCenter) { //检查是否两个中心点
                if (s.charAt(lastCenter) == s.charAt(currentCenter)) {
                    left = lastCenter;
                    right = currentCenter;
                    checkTwoCenter = true;
                }else{
                    left = right = currentCenter;
                }
            }else{  //检查是否一个中心点
                checkTwoCenter = false;
                currentCenter -= 1;
                left = currentCenter;
                right = currentCenter;
            }
            while (left - 1 >= 0 && right + 1 < s.length() && s.charAt(left - 1) == s.charAt(right + 1)) {
                left--;
                right++;
            }
            if (right - left + 1 > maxStr.length())
                maxStr = s.substring(left, right + 1);
            lastCenter = currentCenter;
        }
        return maxStr;
    }

    public static void main(String[] args) {
        最长回文子串 test = new 最长回文子串();
        String str = "ccccbabab";
        System.out.println(test.longestPalindrome(str));
    }

}
