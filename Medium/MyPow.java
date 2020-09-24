package Medium;

public class MyPow {

    public double myPow2(double x, int n) {
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
        double tmp = myPow(x, n / 2);
        if (n % 2 == 1)
            return tmp * tmp * x;
        else if (n % 2 == -1)
            return tmp * tmp / x;
        else
            return tmp * tmp;

    }

    private double pow(double x, int n) {
        if (n == 1)
            return x;
        double tmp = pow(x, n / 2);
        if (n % 2 == 0)
            return tmp * tmp;
        else
            return tmp * tmp * x;
    }

    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n > 0)
            return pow(x, n);
        else
            return 1 / pow(x, -n);
    }

    public static void main(String[] args) {
        MyPow pow = new MyPow();
        double x = 0;
        int n = 0;
        System.out.println(pow.myPow(x, n));
    }
}
