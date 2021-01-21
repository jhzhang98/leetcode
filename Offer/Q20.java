package Offer;

public class Q20 {
    public boolean isNumber(String s) {
        boolean flag = s.matches("[+|-]?[0-9]+[.]?[0-9]+[e|E][-|+]?[0-9]+");
        flag = flag || s.matches("[+|-]?[0-9]+[.][0-9]+" );
        flag = flag || s.matches("[+|-]?[0-9]+");
        return flag;
    }

    public static void main(String[] args) {
        Q20 q20 = new Q20();
        String s = "0e3";
        System.out.println(q20.isNumber(s));
        System.out.println(0000.2);
    }
}
