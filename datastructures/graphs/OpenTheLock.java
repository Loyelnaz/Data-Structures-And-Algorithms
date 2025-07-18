package datastructures.graphs;

import java.util.*;

/**
 * You have a lock in front of you with 4 circular wheels.
 * Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
 * The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
 * Each move consists of turning one wheel one slot.
 *
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 *
 * You are given a list of deadends, meaning if the lock displays any of these codes,
 * the wheels of the lock will stop turning and you will be unable to open it.
 *
 * Given a target representing the value of the wheels that will unlock the lock,
 * return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 *
 * https://leetcode.com/problems/open-the-lock/submissions/1654899067/
 */
public class OpenTheLock {

    public static void main(String[] args) {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";

        System.out.print(openLock(deadends, target));
    }

    static final String START_PATTERN = "0000";

    static class Pair {
        String node;
        int steps;

        Pair(String node, int steps) {
            this.node = node;
            this.steps = steps;
        }
    }

    public static int openLock(String[] deadends, String target) {
        Set<String> seen = new HashSet<>();
        for (String deadend : deadends) {
            if (deadend.equals(START_PATTERN)) {
                return -1;
            }
            seen.add(deadend);
        }

        Queue<Pair> queue = new LinkedList<>();
        seen.add(START_PATTERN);
        queue.add(new Pair(START_PATTERN, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            String node = pair.node;
            int steps = pair.steps;

            if (node.equals(target)) {
                return steps;
            }

            for (String neighbor : neighbors(node)) {
                if (!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    queue.add(new Pair(neighbor, steps + 1));
                }
            }
        }

        return -1;
    }

    private static List<String> neighbors(String node) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int curr = node.charAt(i) - '0';

            for (int element : new int[]{-1, 1}) {
                int x = (curr - element + 10) % 10;
                // we don't want to include the current character so we use substring(startIndex, currentIndex)
                // The currentIndex is excluded if we use the above
                // substring(beginIndex) -> all characters starting from "beginIndex" to the end of the string are included
                result.add(node.substring(0, i) + x + node.substring(i + 1));
            }
        }

        return result;
    }
}
