package weekly.w221;

public class Q2 {
    public int eatenApples(int[] apples, int[] days) {
        int curEaten = 0;
        int maxDay = 0;
        boolean eatMaxDay = false;
        for (int i = 0; i < apples.length; i++) {
            int day = i + 1;
            int dayEat = day + Math.min(apples[i], days[i]) - 1;
            if (maxDay > day) {
                int dayPut = day + days[i] - 1;
                if (maxDay >= day + (dayPut - dayEat) - 1)
                    dayEat = dayPut;
                else {
                    // 从第maxDay天开始吃，能吃几天？
                    int localDay = days[i] - (maxDay - day);
                    if (eatMaxDay)
                    dayEat = maxDay + Math.min(apples[i], localDay);
                    else
                        dayEat = maxDay + Math.min(apples[i], localDay) - 1;
                }
            }
            if (apples[i] == 0) {
                dayEat = day;
                if (maxDay < dayEat) {
                    maxDay = dayEat;
                    eatMaxDay = false;
                }else
                    eatMaxDay = true;
                continue;
            }
            eatMaxDay = true;
            curEaten += Math.max(dayEat - maxDay, 0);
            maxDay = Math.max(maxDay, dayEat);
        }
        return curEaten;
    }

    public static void main(String[] args) {
        Q2 q2 = new Q2();
        int[] apples = {4,2,5};
        int[] days = {6,1,10};
        System.out.println(q2.eatenApples(apples, days));
    }
}
