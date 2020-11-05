package Medium;

import java.util.*;

public class WordLadder {
    private int distBetween(String str1, String str2) {
        int dis = 0;
        for (int i = 0; i < str1.length(); i++)
            if (str1.charAt(i) != str2.charAt(i))
                dis++;
        return dis;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord) || !wordList.contains(endWord))
            return 0;
//        wordList.removeIf(str -> str.equals(beginWord));
        wordList.remove(beginWord);
        Map<String, List<String>> adjPoints = new HashMap<>();
        Map<String, Integer> dis = new HashMap<>();
        adjPoints.put(beginWord, new ArrayList<>());
        dis.put(beginWord, 0);
        for (String word : wordList) {
            adjPoints.put(word, new ArrayList<>());
            dis.put(word, -1);
        }

        for (String word : wordList) {
            if (1 == distBetween(word, beginWord))
                adjPoints.get(beginWord).add(word);
        }

        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            for (int j = i + 1; j < wordList.size(); j++) {
                String next = wordList.get(j);
                int d = distBetween(word, next);
                if (d == 1) {
                    adjPoints.get(word).add(next);
                    adjPoints.get(next).add(word);
                }
            }
        }
        Set<String> searched = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            if (word.equals(endWord))
                return dis.get(word) + 1;
            int distance = dis.get(word);
            for (String next : adjPoints.get(word)) {
                if (dis.get(next) == -1) {
                    dis.put(next, distance + 1);
                    queue.add(next);
                } else {
                    if (searched.contains(next) && (dis.get(next) > distance + 1)) {
                        dis.put(next, distance + 1);
                        queue.add(next);
                    }
                }
            }
            searched.add(word);
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder ladder = new WordLadder();
        String beginWord = "hit", endWord = "cog";
        String[] wordList = {"hot", "dot", "tog", "cog"};
        System.out.println(ladder.ladderLength(beginWord, endWord, new ArrayList<>(Arrays.asList(wordList))));
    }
}
