package Medium;

import java.util.*;
import java.util.stream.Collectors;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        // 1. 初始化taskList，里面是每个task需要执行的次数
        int[] taskNumAll = new int[26];
        for (char task : tasks)
            taskNumAll[task - 'A']++;
        Queue<Integer> task = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int taskNum : taskNumAll)
            if (taskNum != 0)
                task.add(taskNum);

        int exeTime = 0;
        while (true) {
            List<Integer> wave = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                exeTime++;
                if (task.isEmpty() && wave.isEmpty())
                    return exeTime - 1;
                if (task.isEmpty())
                    continue;
                int maxTaskNum = task.poll();
                if (maxTaskNum == 0)
                    return exeTime - 1;
                if (maxTaskNum != 1)
                    wave.add(maxTaskNum - 1);
            }
            task.addAll(wave);
        }
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'E'};
        int n = 2;
        System.out.println(scheduler.leastInterval(tasks, n));
    }
}