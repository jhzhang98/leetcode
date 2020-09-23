package Medium;

public class MyPow {
    public double myPow(double x, int n) {
        if (x == 0 && n != 0)
            return 0;
        switch (n) {
            case 0:
                return 1;
            case 1:
                return x;
            case -1:
                return 1 / x;
        }
        if (n % 2 == 1)
            return myPow(x, n / 2) * myPow(x, n / 2) * x;
        else if (n % 2 == -1)
            return myPow(x, n / 2) * myPow(x, n / 2) / x;
        else
            return myPow(x, n / 2) * myPow(x, n / 2);
    }

    public static void main(String[] args) {
        MyPow pow = new MyPow();
        double x = 0;
        int n = 0;
        System.out.println(pow.myPow(x, n));
    }
}
