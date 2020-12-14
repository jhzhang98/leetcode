package Medium;

public class BrokenCalculator {
    public int brokenCalc(int X, int Y) {
        if (Y <= X)
            return X - Y;
        int odd = Y % 2 == 0 ? 0 : 1;
        int tmp = Y + odd;
        int divTime = 0;
        while (tmp > X) {
            if (tmp % 2 == 1) {
                odd++;
                tmp += 1;
            }
            tmp = tmp >> 1;
            divTime++;
        }
        return X - tmp + odd + divTime;
    }

    public static void main(String[] args) {
        BrokenCalculator calculator = new BrokenCalculator();
        int X = 6, Y = 298373;
        System.out.println(calculator.brokenCalc(X, Y));
    }
}
