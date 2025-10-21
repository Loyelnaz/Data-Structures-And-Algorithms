package algorithms.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/climbing-stairs/description/
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
        System.out.println("Space Optimized (Tabulation):  " + new Solution().climbStairsOptimized(5));
        System.out.println("Memoization Solution: " + new Solution().climbStairsMemoization(5));
    }

    static class Solution {
        int[] dp;

        /**
         * Time Complexity - O(n)
         * Space Complexity - O(1)
         */
        public int climbStairsOptimized(int n) {
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

        /**
         * Time Complexity - O(n)
         * Space Complexity - O(n)
         */
        private int climbStairsMemoization(int n) {
            dp = new int[n + 1];
            Arrays.fill(dp, -1);

            return climbStairsDpMemoization(n);
        }

        public int climbStairsDpMemoization(int n) {
            // base case is started from step 1 based on the problem constraints
            if (n == 1) {
                return 1;
            }

            if (n == 2) {
                return 2;
            }

            if (dp[n] != -1) {
                return dp[n];
            }

            dp[n] = climbStairsDpMemoization(n - 1) + climbStairsDpMemoization(n - 2);

            return dp[n];
        }

        Map<Integer, Integer> ans;
        public int stairs(int[] cost) {
            ans = new HashMap<>();
            return dp(ans, cost, 0);
        }

        private int dp(Map<Integer, Integer> ans, int[] cost, int index) {
            if (index <= 0) {
                return 0;
            }
            if (ans.containsKey(index)) {
                return ans.get(index);
            }
            ans.put(index, Math.min(dp(ans, cost, index - 1) + cost[index - 1], dp(ans, cost, index - 2) + cost[index - 2]));
            return ans.get(index);
        }
    }
}
