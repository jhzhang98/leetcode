package biweekly.w42;

import java.util.LinkedList;
import java.util.Queue;

public class Q1 {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> stu = new LinkedList<>();
        for (int student : students) stu.add(student);
        Queue<Integer> san = new LinkedList<>();
        for (int sandwich : sandwiches) san.add(sandwich);

        int notMeet = 0;
        while (!stu.isEmpty()) {
            if (stu.peek().equals(san.peek())){
                stu.poll();
                san.poll();
                notMeet = 0;
            }else{
                stu.add(stu.poll());
                notMeet++;
            }
            if (notMeet == stu.size()){
                break;
            }
        }
        return notMeet;
    }
}
