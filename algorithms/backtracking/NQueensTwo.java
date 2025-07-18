package algorithms.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * The N-Queens puzzle is the famous problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * Given an integer n, return the number of distinct solutions to the N-Queens puzzle.
 *
 * https://leetcode.com/problems/n-queens-ii/
 */
public class NQueensTwo {

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }

    public static int totalNQueens(int n) {
        return backtrack(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    private static int backtrack(int n, int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> cols) {
        // Base case - N queens have been placed
        if (row == n) {
            return 1;
        }

        int solutions = 0;
        for (int col = 0; col < n; col++) {
            int currDiagonal = row - col;
            int currAntiDiagonal = row + col;
            // If the queen is not placeable
            if (cols.contains(col) || diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagonal)) {
                continue;
            }

            // "Add" the queen to the board
            cols.add(col);
            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiagonal);

            // Move on to the next row with the updated board state
            solutions += backtrack(n, row + 1, diagonals, antiDiagonals, cols);

            // "Remove" the queen from the board since we have already
            // explored all valid paths using the above function call
            cols.remove(col);
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
        }

        return solutions;
    }
}
