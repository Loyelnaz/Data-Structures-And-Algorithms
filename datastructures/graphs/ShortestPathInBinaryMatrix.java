package datastructures.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 */
public class ShortestPathInBinaryMatrix {

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    static class State {
        int row;
        int col;
        int steps;

        State(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }

    // consider all 8 possible direction - horizontal, vertical and diagonal
    static int[][] directions = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,1},{1,0},{1,-1}};

    /**
     * For a given step / level, we will keep track of different directions (at most 8 directions)
     * Time Complexity - O(n^2), it's equal to the number of nodes
     * Space Complexity - O(n^2)
     */
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        int n = grid.length;
        boolean[][] seen = new boolean[n][n];
        Queue<State> queue = new LinkedList<>();
        seen[0][0] = true;
        queue.add(new State(0, 0, 1));

        while (!queue.isEmpty()) {
            State state = queue.remove();
            int row = state.row, col = state.col, steps = state.steps;
            if (row == n - 1 && col == n - 1) {
                return steps;
            }

            for (int[] direction : directions) {
                int nextRow = row + direction[0], nextCol = col + direction[1];
                if (valid(grid, nextRow, nextCol) && !seen[nextRow][nextCol]) {
                    seen[nextRow][nextCol] = true;
                    queue.add(new State(nextRow, nextCol, steps + 1));
                }
            }
        }

        return -1;
    }

    private static boolean valid(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 0;
    }

}
