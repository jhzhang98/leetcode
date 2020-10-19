package Medium;

import java.util.Arrays;
import java.util.Comparator;

public class BestTeamWithNoConflicts {
    class Person {
        int score;
        int age;

        public Person(int score, int age) {
            this.score = score;
            this.age = age;
        }
    }

    /***
     * 先按照或者分数升序排列，再将剩余按照另一个属性排列
     * dp[i]为最后一个球员为players[i]时的最大分数，结果为 Max(dp)
     * 有dp[i+1] = for j <= i+1 :
     *              if (! (players[j].age < players[i+1].age && players[j].score > players[i+1].score) )
     *                  dp[i+1] = Max(dp[i+1], dp[j] + players[i+1].score)
     * 为何正确？
     * 按照年龄排序之后，下一个球员年龄一定不小，所以如果有结果，将结果按照年龄升序排列，最后一个球员也是年龄最大的
     */
    public int bestTeamScore(int[] scores, int[] ages) {
        Person[] players = new Person[scores.length];
        for (int i = 0; i < scores.length; i++)
            players[i] = new Person(scores[i], ages[i]);

        Arrays.sort(players, (p1, p2) ->{
            if(p1.age < p2.age)
                return -1;
            else if(p1.age == p2.age)
                return Integer.compare(p1.score, p2.score);
            return 1;
        });
        int[] dp = new int[players.length];
        dp[0] = players[0].score;

        int maxScore = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = players[i].score;
            for (int j = 0; j < i; j++) {
                if (!(players[j].age < players[i].age && players[j].score > players[i].score))
                    dp[i] = Math.max(dp[i], dp[j] + players[i].score);
            }
            maxScore = Math.max(maxScore, dp[i]);
        }
        return maxScore;
    }

    public static void main(String[] args) {
        BestTeamWithNoConflicts team = new BestTeamWithNoConflicts();
        int[] scores = {1, 3, 7, 3, 2, 4, 10, 7, 5};
        int[] ages = {4, 5, 2, 1, 1, 2, 4, 1, 4};
        System.out.println(team.bestTeamScore(scores, ages));
    }
}
