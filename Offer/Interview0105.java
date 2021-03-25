package Offer;

public class Interview0105 {
    public boolean oneEditAway(String first, String second) {
        if (first.length() == 0 && second.length() == 0) return true;
        else if (first.length() + second.length() == 1) return true;
        else if (Math.abs(first.length() - second.length()) > 1) return false;
        int ptrA = 0, ptrB = 0;
        int opt = 0;
        while (ptrA < first.length() && ptrB < second.length()) {
            if (first.charAt(ptrA) == second.charAt(ptrB)) {
                ptrA++;
                ptrB++;
            } else {
                if (opt == 1) return false;
                if (first.length() == second.length()) {     // replace
                    ptrA++;
                    ptrB++;
                } else if (first.length() > second.length())
                    ptrA++;
                else
                    ptrB++;
                opt++;
            }
        }
        int remainedOpt = first.length() - ptrA + second.length() - ptrB;
        return remainedOpt <= 1;
    }

    public static void main(String[] args) {
        String first = "a";
        String second = "ab";
        System.out.println(new Interview0105().oneEditAway(first, second));
    }
}
