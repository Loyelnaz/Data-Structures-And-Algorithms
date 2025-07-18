package datastructures.graphs;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder/description/
 */
public class WordLadder {

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");

        System.out.print(ladderLength("hit", "cog", wordList));
    }

    static class Pair {
        String word;
        int steps;

        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }

    /**
     * Time Complexity - O(n * m), if is the length of neighbors at each try (it would be O(25 * m) ~ O(m)
     * Space Complexity - O(n * m)
     *
     * This problem can be solved using bidirectional BFS with better search capabilities (learn more)
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        seen.add(beginWord);
        queue.add(new Pair(beginWord, 1));

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            String word = pair.word;
            int steps = pair.steps;

            if (word.equals(endWord)) {
                return steps;
            }

            for (String neighbor : neighbors(word)) {
                if (wordSet.contains(neighbor) && !seen.contains(neighbor)) {
                    seen.add(neighbor);
                    queue.add(new Pair(neighbor, steps + 1));
                }
            }
        }

        return 0;
    }

    private static List<String> neighbors(String word) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != currentChar) {
                    result.add(word.substring(0, i) + ch + word.substring(i + 1));
                }
            }
        }
        return result;
    }
}
