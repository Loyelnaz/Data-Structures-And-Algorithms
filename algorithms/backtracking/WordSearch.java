package algorithms.backtracking;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * https://leetcode.com/problems/word-search/description/
 */
public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] seen = new boolean[m][n];

        // as there is no fixed starting point for the word, we need to do the traversal from each of the (row, col)
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (word.charAt(0) == board[row][col]) {
                    seen[row][col] = true;
                    if (backtrack(board, word, 1, row, col, seen)) {
                        return true;
                    }
                    seen[row][col] = false;
                }
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] board, String word, int index, int row, int col, boolean[][] seen) {
        if (index == word.length()) {
            return true;
        }

        for (int[] direction : directions) {
            int nextRow = direction[0] + row;
            int nextCol = direction[1] + col;

            if (isValid(board, nextRow, nextCol) && !seen[nextRow][nextCol]) {
                if (word.charAt(index) == board[nextRow][nextCol]) {
                    seen[nextRow][nextCol] = true;
                    if (backtrack(board, word, index + 1, nextRow, nextCol, seen)) {
                        return true;
                    }
                    seen[nextRow][nextCol] = false;
                }
            }
        }

        return false;
    }

    private static boolean isValid(char[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }
}
