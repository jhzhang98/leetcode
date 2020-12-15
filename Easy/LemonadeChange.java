package Easy;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int[] remained = new int[3];
        for (int bill : bills) {
            int change = bill - 5;
            if (change == 5) {
                remained[0]--;
                if (remained[0] < 0)
                    return false;
            } else if (change == 15) {
                if (remained[1] > 0 && remained[0] > 0) {
                    remained[0]--;
                    remained[1]--;
                    continue;
                } else if (remained[0] > 2) {
                    remained[0] -= 3;
                    continue;
                }
                return false;
            }
            remained[bill / 9]++;
        }
        return true;
    }

    public static void main(String[] args) {
        LemonadeChange change = new LemonadeChange();
        int[] bills = {5, 5, 5, 10, 5, 5, 10, 20, 20, 20};
        System.out.println(change.lemonadeChange(bills));
    }
}
