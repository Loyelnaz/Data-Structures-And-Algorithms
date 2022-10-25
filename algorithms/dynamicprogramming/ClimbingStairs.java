package algorithms.dynamicprogramming;

/**
 * Leetcode - https://leetcode.com/problems/climbing-stairs/description/
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(4));
    }

    static class Solution {
        /**
         * Time Complexity - O(n)
         * Space Complexity - O(1)
         */
        public int climbStairs(int n) {
            // base case is started from step 1 based on the problem constraints
            if (n == 1) {
                return 1;
            }

            // Since we would just require previous two states, we used two variables,
            // instead of having an array for memoization
            int backTwo = 1;
            int backOne = 2;

            for (int i = 3; i <= n; i++) {
                int temp = backOne;
                backOne = backOne + backTwo;
                backTwo = temp;
            }
            return backOne;
        }
    }
}
