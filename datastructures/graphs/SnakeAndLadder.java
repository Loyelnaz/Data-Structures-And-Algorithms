package datastructures.graphs;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * https://leetcode.com/problems/snakes-and-ladders/description/
 */
public class SnakeAndLadder {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        // if you use primitive type here, the Arrays.asList() will return incorrect value
        // That is because int[] will be treated as a single element, and Integer[] is treated as a mutable list
        Integer[] columns = new Integer[n];
        for (int i = 0; i < n; i++) {
            columns[i] = i;
        }
        Pair<Integer, Integer>[] cells = new Pair[n * n + 1];
        int label = 1;
        for (int row = n - 1; row >= 0; row--) {
            for (int column : columns) {
                cells[label++] = new Pair(row, column);
            }
            Collections.reverse(Arrays.asList(columns));
        }

        int[] distance = new int[n * n + 1];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new LinkedList<>();
        distance[1] = 0;
        queue.add(1);

        while (!queue.isEmpty()) {
            int curr = queue.remove();

            for (int next = curr + 1; next <= Math.min(curr + 6, n * n); next++) {
                int row = cells[next].getKey(), col = cells[next].getValue();
                int destination = board[row][col] != -1 ? board[row][col] : next;

                if (distance[destination] == -1) {
                    distance[destination] = distance[curr] + 1;
                    queue.add(destination);
                }
            }
        }

        return distance[n * n];
    }

}
