package algorithms.dynamicprogramming;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 *
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 *
 * You can either start from the step with index 0, or the step with index 1.
 *
 * Return the minimum cost to reach the top of the floor.
 */
public class MinimumCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {10,15,20};
        System.out.println(minCostClimbingStairsUsingConstantSpace(cost));
    }

    /**
     * Solved using bottom up approach of DP - from a particular step, we could have reached here either climbing one step or two steps
     *
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public static int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length + 1];

        for (int i = 2; i < minCost.length; i++) {
            int takeOneStep = minCost[i - 1] + cost[i - 1];
            int takeTwoStep = minCost[i - 2] + cost[i - 2];

            minCost[i] = Math.min(takeOneStep, takeTwoStep);
        }

        return minCost[minCost.length - 1];
    }

    /**
     * Since we need only past two steps, we need not use additional space to store this
     */
    public static int minCostClimbingStairsUsingConstantSpace(int[] cost) {
        int takeOneStep = 0;
        int takeTwoStep = 0;

        for (int i = 2; i < cost.length + 1; i++) {
            int temp = takeOneStep;
            takeOneStep = Math.min(takeOneStep + cost[i - 1], takeTwoStep + cost[i - 2]);
            takeTwoStep = temp;
        }

        return takeOneStep;
    }
}
