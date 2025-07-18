package datastructures.graphs;

/**
 * https://leetcode.com/problems/max-area-of-island/
 */
public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
        System.out.println(maxAreaOfIsland(isConnected));
    }

    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * Time Complexity: O(R*C), where R is the number of rows in the given grid,
     *                            and C is the number of columns. We visit every square once.
     *
     * Space complexity: O(R*C), the space used by seen to keep track of visited squares and the space used by stack.
     */
    public static int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxArea = Integer.MIN_VALUE;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                int area = 0;
                if (grid[row][col] == 1 && !visited[row][col]) {
                    visited[row][col] = true;
                    area = dfs(grid, visited, row, col);
                }
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    private static int dfs(int[][] grid, boolean[][] visited, int row, int col) {
        int area = 1;
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (valid(grid, newRow, newCol) && !visited[newRow][newCol] && grid[newRow][newCol] == 1) {
                visited[newRow][newCol] = true;
                area += dfs(grid, visited, newRow, newCol);
            }
        }
        return area;
    }

    private static boolean valid(int[][] grid, int row, int col) {
        boolean rowBound = row >= 0 && row < grid.length;
        boolean colBound = col >= 0 && col < grid[0].length;

        return rowBound && colBound;
    }
}
