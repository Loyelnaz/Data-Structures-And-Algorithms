package datastructures.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an m x n 2D binary grid which represents a map of 1 (land) and 0 (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent land cells horizontally or vertically.
 *
 * https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] isConnected = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(isConnected));
    }

    /**
     * Time Complexity: O(m * n)
     */
    public static int numIslands(char[][] grid) {
        Set<HashMap.SimpleEntry<Integer, Integer>> seen = new HashSet<>();
        int islandCount = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (dfs(grid, seen, row, col)) {
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    private static boolean dfs(char[][] grid, Set<HashMap.SimpleEntry<Integer, Integer>> seen, int row, int col) {
        boolean rowBound = row < 0 || row >= grid.length;
        boolean colBound = col < 0 || col >= grid[0].length;

        if (rowBound || colBound) {
            return false;
        }

        HashMap.SimpleEntry<Integer, Integer> currentPosition = new HashMap.SimpleEntry<>(row, col);
        if (seen.contains(currentPosition)) {
            return false;
        }
        seen.add(currentPosition);

        if (grid[row][col] == '0') {
            return false;
        }

        dfs(grid, seen, row + 1, col);
        dfs(grid, seen, row - 1, col);
        dfs(grid, seen, row, col + 1);
        dfs(grid, seen, row, col - 1);

        return true;
    }

    // Another way of solving the same problem
    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int numIslandsIterative(char[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int islandCount = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1' && !seen[row][col]) {
                    islandCount++;
                    seen[row][col] = true;
                    dfs(grid, seen, row, col);
                }
            }
        }

        return islandCount;
    }

    private static void dfs(char[][] grid, boolean[][] seen, int row, int col) {
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (valid(grid, newRow, newCol) && grid[newRow][newCol] == '1' && !seen[newRow][newCol]) {
                seen[newRow][newCol] = true;
                dfs(grid, seen, newRow, newCol);
            }
        }
    }

    private static boolean valid(char[][] grid, int row, int col) {
        boolean rowBound = row < 0 || row >= grid.length;
        boolean colBound = col < 0 || col >= grid[0].length;

        return !rowBound && !colBound;
    }
}
