package Offer;

public class Q05 {
    public String replaceSpace(String s) {
        s = s.replaceAll("[ ]", "%20");
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new Q05().replaceSpace("We are happy."));
    }
}
