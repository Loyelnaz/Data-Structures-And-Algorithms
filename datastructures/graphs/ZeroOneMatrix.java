package datastructures.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        System.out.println(Arrays.deepToString(updateMatrix(mat)));
    }

    static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

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

    /**
     * Time Complexity - O(m*n), because the BFS only visits each square once, and does a constant amount of work each time.
     * Space Complexity - O(m*n), for the queue and seen.
     */
    public static int[][] updateMatrix(int[][] mat) {
        Queue<State> queue = new LinkedList<>();
        boolean[][] seen = new boolean[mat.length][mat[0].length];

        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                if (mat[row][col] == 0) {
                    queue.add(new State(row, col, 1));
                    seen[row][col] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            State state = queue.remove();
            int row = state.row, col = state.col, steps = state.steps;
            for (int[] direction : directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];

                if (valid(mat, nextRow, nextCol) && !seen[nextRow][nextCol]) {
                    queue.add(new State(nextRow, nextCol, steps + 1));
                    seen[nextRow][nextCol] = true;
                    mat[nextRow][nextCol] = steps;
                }
            }
        }
        return mat;
    }

    private static boolean valid(int[][] mat, int row, int col) {
        return row >= 0 && row < mat.length && col >= 0 && col < mat[0].length && mat[row][col] == 1;
    }
}
