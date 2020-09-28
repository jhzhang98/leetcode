package Medium;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] waitTime = new int[T.length];
        if (T.length == 0)
            return waitTime;
        Stack<Integer> waitTemp = new Stack<>();
        waitTemp.add(0);
        for (int i = 1; i < T.length; i++) {
            while (!waitTemp.isEmpty() && T[waitTemp.peek()] < T[i]) {
                int index = waitTemp.pop();
                waitTime[index] = i - index;
            }
            waitTemp.add(i);
        }
        return waitTime;
    }

    public static void main(String[] args) {
        DailyTemperatures temp = new DailyTemperatures();
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(temp.dailyTemperatures(T)));
    }
}
