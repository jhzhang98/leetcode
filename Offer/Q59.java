package Offer;
import java.util.*;

public class Q59 {
    class MaxQueue {
        Queue<Integer> num = new LinkedList<>();
        List<Integer> max = new LinkedList<>();
        public MaxQueue() {

        }

        public int max_value() {
            if (num.size() == 0)
                return -1;
            return max.get(0);
        }

        public void push_back(int value) {
            num.add(value);

            while (max.size() != 0 && value > max.get(max.size() - 1))
                max.remove(max.size() - 1);
            max.add(value);
        }

        public int pop_front() {
            if (num.size() <= 0)
                return -1;
            int popNum = num.poll();
            if (max.get(0) == popNum)
                max.remove(max.get(0));
            return popNum;
        }
    }

    public static void main(String[] args) {

    }
}
