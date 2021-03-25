package Offer;

import java.util.*;

public class Interview1722 {
    List<String> res = new ArrayList<>();

    private boolean canReach(char[] srcWord, char[] targetWord) {
        int sum = 0;
        for (int i = 0; i < srcWord.length; i++)
            sum += (srcWord[i] != targetWord[i]) ? 1 : 0;
        return sum == 1;
    }

    private void dfs(String beginWord, String endWord, List<String> wordList, HashSet<String> visited, Deque<String> path) {
        if (visited.contains(beginWord)) return;
        if (res.size() != 0) return;
        if (beginWord.equals(endWord)) {
            res = new ArrayList<>(path);
            return;
        }
        visited.add(beginWord);
        for (int i = wordList.size() - 1; i >= 0; i--) {
            String str = wordList.get(i);
            if (!canReach(beginWord.toCharArray(), str.toCharArray())) continue;
            wordList.remove(i);
            path.addLast(str);
            dfs(str, endWord, wordList, visited, path);
            path.removeLast();
            wordList.add(str);
        }
    }

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        Deque<String> queue = new LinkedList<>();
        queue.add(beginWord);
        dfs(beginWord, endWord, wordList, new HashSet<>(), queue);
        return res;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(new Interview1722().findLadders(beginWord, endWord, wordList));
    }
}
