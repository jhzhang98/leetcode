package Medium;

import java.util.LinkedList;
import java.util.List;

public class DesignFrontMiddleBackQueue {
    static class FrontMiddleBackQueue {
        List<Integer> queue;

        public FrontMiddleBackQueue() {
            queue = new LinkedList<>();
        }

        public void pushFront(int val) {
            queue.add(0, val);
        }

        public void pushMiddle(int val) {
            queue.add(queue.size() / 2, val);
        }

        public void pushBack(int val) {
            queue.add(queue.size(), val);
        }

        public int popFront() {
            if (queue.size() == 0)
                return -1;
            return queue.remove(0);
        }

        public int popMiddle() {
            if (queue.size() == 0)
                return -1;
            return queue.remove((queue.size() - 1) / 2);
        }

        public int popBack() {
            if (queue.size() == 0)
                return -1;
            return queue.remove(queue.size() - 1);
        }

        @Override
        public String toString() {
            return String.valueOf(queue);
        }
    }

    public static void main(String[] args) {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushFront(1);   // [1]
        q.pushBack(2);    // [1, 2]
        q.pushMiddle(3);  // [1, 3, 2]
        q.pushMiddle(4);  // [1, 4, 3, 2]
        q.popFront();     // 返回 1 -> [4, 3, 2]
        q.popMiddle();    // 返回 3 -> [4, 2]
        q.popMiddle();    // 返回 4 -> [2]
        q.popBack();      // 返回 2 -> []
        q.popFront();     // 返回 -1 -> [] （队列为空）
    }
}
