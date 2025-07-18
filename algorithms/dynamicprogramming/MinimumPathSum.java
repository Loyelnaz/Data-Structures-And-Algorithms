package algorithms.dynamicprogramming;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * Given a "m x n" grid filled with non-negative numbers, find a path from top left to bottom right,
 * which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6}};
        System.out.println(minPathSumDp1d(grid));
    }

    /**
     * Solved using recursion
     * Time complexity - O(2^(m+n))
     * Space complexity - O(m + n)
     */
    public static int minPathSumRecursion(int[][] grid) {
        return minPath(grid, 0, 0);
    }

    public static int minPath(int[][] grid, int i, int j) {
        if (i == grid.length || j == grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        return grid[i][j] + Math.min(minPath(grid, i, j+1), minPath(grid, i+1, j));
    }

    /**
     * Solved using 2D DP array
     *
     * Recurrence relation - dp(i,j) = grid(i,j) + min(dp(i+1,j), dp(i,j+1))
     *
     * Time complexity - O(m.n)
     * Space complexity - O(m.n)
     */
    public static int minPathSumDp2d(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[][] dp = new int[rowLength][colLength];

        for (int row = rowLength - 1; row >= 0; row--) {
            for (int col = colLength - 1; col >= 0; col--) {
                if (row == rowLength - 1 && col != colLength - 1) {
                    dp[row][col] = grid[row][col] + dp[row][col + 1];
                } else if (col == colLength - 1 && row != rowLength - 1) {
                    dp[row][col] = grid[row][col] + dp[row + 1][col];
                } else if (row != rowLength - 1 && col != colLength - 1) {
                    dp[row][col] = grid[row][col] + Math.min(dp[row + 1][col], dp[row][col + 1]);
                } else {
                    dp[row][col] = grid[row][col];
                }
            }
        }

        return dp[0][0];
    }

    /**
     * Solved using 1D DP array. We wouldn't require a 2D array to store the result i.e.,
     * if we look at the top row of a 2D array, it is basically the result got by either doing a summation of the row below it
     * OR based on the minimum entry
     *
     * Time complexity - O(m.n)
     * Space complexity - O(1)
     */
    public static int minPathSumDp1d(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[] dp = new int[colLength];

        for (int row = rowLength - 1; row >= 0; row--) {
            for (int col = colLength - 1; col >= 0; col--) {
                if (row == rowLength - 1 && col != colLength - 1) {
                    dp[col] = grid[row][col] + dp[col + 1];
                } else if (col == colLength - 1 && row != rowLength - 1) {
                    dp[col] = grid[row][col] + dp[col];
                } else if (row != rowLength - 1 && col != colLength - 1) {
                    dp[col] = grid[row][col] + Math.min(dp[col], dp[col + 1]);
                } else {
                    dp[col] = grid[row][col];
                }
            }
        }

        return dp[0];
    }
}
