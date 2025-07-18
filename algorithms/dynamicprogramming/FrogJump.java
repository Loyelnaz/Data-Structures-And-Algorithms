package algorithms.dynamicprogramming;

import java.util.Arrays;

/**
 * https://www.codingninjas.com/codestudio/problems/frog-jump_3621012
 */
public class FrogJump {

    public static void main(String[] args) {
        int[] heights = {10, 20, 30, 10};
//        int[] heights = {10, 50, 10};
        System.out.println("Memoization:  " + frogJumpMemoization(heights.length, heights));
        System.out.println("Tabulation:  " + frogJumpTabulation(heights.length, heights));
        System.out.println("Tabulation - Space Optimized:  " + frogJumpTabulationOptimized(heights.length, heights));
    }

    /**
     * Why a GREEDY solution (taking minimum out of every choice) would not work?
     * If we have an array, say, {30,10,60,10,60,50}, we would have chosen,
     * 30->10(20)->10(20)->50(60), would have resulted in 60.
     * But optimal solution would be, 30->60(30)->60(30)->50(40), would be 40
     *
     * To reach f(n-1), we would need minimum energy to reach (n-1) from 0
     * Base case - to reach 0 from 0 would be 0
     *
     * To reach f(n-1), the frog can either jump one step OR two steps.
     *
     * The recurrence relation would look like:
     * f(n) = min(f(n-1) + abs(heights[i) - heights[i-1]), f(n-2) + abs(heights[i) - heights[i-1]))
     */
    public static int frogJumpMemoization(int n, int heights[]) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return frogJumpMemoization(n - 1, heights, dp);
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n) + O(n)
     */
    private static int frogJumpMemoization(int index, int heights[], int[] dp) {
        if (index == 0) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int oneStep = frogJumpMemoization(index - 1, heights, dp) + Math.abs(heights[index] - heights[index - 1]);

        int twoStep = Integer.MAX_VALUE;
        if (index > 1) {
            twoStep = frogJumpMemoization(index - 2, heights, dp) + Math.abs(heights[index] - heights[index - 2]);
        }

        return dp[index] = Math.min(oneStep, twoStep);
    }

    private static int frogJumpTabulation(int n, int heights[]) {
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < heights.length; i++) {
            int oneStep = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);

            int twoStep = Integer.MAX_VALUE;
            if (i > 1) {
                twoStep = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }

            dp[i] = Math.min(oneStep, twoStep);
        }

        return dp[n - 1];
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(1) as we are using only constant variables for tabulation
     */
    private static int frogJumpTabulationOptimized(int n, int heights[]) {
        int oneStep = 0, twoStep = 0;
        for (int i = 1; i < heights.length; i++) {
            int firstStep = oneStep + Math.abs(heights[i] - heights[i - 1]);

            int secondStep = Integer.MAX_VALUE;
            if (i > 1) {
                secondStep = twoStep + Math.abs(heights[i] - heights[i - 2]);
            }

            int currentValue = Math.min(firstStep, secondStep);

            twoStep = oneStep;
            oneStep = currentValue;
        }

        return oneStep;
    }
}
