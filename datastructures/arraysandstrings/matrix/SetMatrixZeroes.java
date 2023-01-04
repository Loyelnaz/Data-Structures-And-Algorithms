package datastructures.arraysandstrings.matrix;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 *
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{0,1,1}};

        setZeroes(matrix);
        printMatrix(matrix);
    }

    /**
     * Approach 1 (Brute-Force):
            * Traverse through the matrix, whenever we find 0, we traverse from starting of the row to the end,
              and mark the position with an element that doesn't below to the array. Do the same thing for the columns too
            * Traverse the matrix again, and mark all the position with the special elements as 0
            * Time - O((n*m)*(n+m)) - we need to traverse through the matrix, and for every traversal,
              we would need to traverse over the row and column
     * Approach 2 (Additional space):
            * Take two arrays, one for row and the other for column
            * Traverse through the matrix, whenever we find a zero, we mark the array indices of row and column array as 0
            * Traverse through the matrix again, if at that row and column position,
              if we have either row or column marked as 0, we mark the position to be 0
            * Time - O((n*m)+(n*m)) - we traversed the matrix twice
            * Space - O(n+m) - for the two arrays
     * Approach 3:
            * Instead of taking two additional arrays, we can have first "row" to store zeroes occurring in a given column, and vice versa
            *
     */
    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstColumn = false;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColumn = true;
            }
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (firstColumn) {
                matrix[i][0] = 0;
            }
        }

    }

    private static void printMatrix(int[][] matrix) {
        int cols = matrix[0].length;

        for (int[] ints : matrix) {
            for (int j = 0; j < cols; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println("");
        }
    }
}
