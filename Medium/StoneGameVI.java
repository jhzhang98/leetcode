package Medium;

import java.util.PriorityQueue;

public class StoneGameVI {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        PriorityQueue<int[]> scoreSum = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0], o1[0]));
        for (int i = 0; i < aliceValues.length; i++) {
            int[] score = new int[]{aliceValues[i] + bobValues[i], i};
            scoreSum.add(score);
        }

        int scoreA = 0;
        int scoreB = 0;
        boolean aliceTurn = true;

        while (!scoreSum.isEmpty()) {
            int[] score = scoreSum.poll();

            if (aliceTurn) {
                if (!scoreSum.isEmpty() && score[0] == scoreSum.peek()[0]) {
                    int[] peek = scoreSum.poll();
                    if (aliceValues[score[1]] > bobValues[peek[1]]) {
                        scoreA += aliceValues[score[1]];
                        scoreSum.add(peek);
                    } else {
                        scoreA += aliceValues[peek[1]];
                        scoreSum.add(score);
                    }
                } else
                    scoreA += aliceValues[score[1]];
                aliceTurn = false;
            } else {
                if (!scoreSum.isEmpty() && score[0] == scoreSum.peek()[0]) {
                    int[] peek = scoreSum.poll();
                    if (bobValues[score[1]] > aliceValues[peek[1]]) {
                        scoreB += bobValues[score[1]];
                        scoreSum.add(peek);
                    } else {
                        scoreB += bobValues[peek[1]];
                        scoreSum.add(score);
                    }
                } else
                    scoreB += bobValues[score[1]];
                aliceTurn = true;
            }
        }
        if (scoreA == scoreB)
            return 0;
        else if (scoreA > scoreB)
            return 1;
        return -1;
    }

    public static void main(String[] args) {
        StoneGameVI gameVI = new StoneGameVI();
        int[] aliceValue = {1, 3};
        int[] bobValue = {2, 1};
        System.out.println(gameVI.stoneGameVI(aliceValue, bobValue));
    }
}
