package algorithms.dynamicprogramming;

public class FibonacciBottomUpApproach {
    public static void main(String[] args) {
        System.out.println(new FibonacciBottomUpApproach.Solution().fibonacci(7));
        System.out.println(new FibonacciBottomUpApproach.Solution().fibonacciSpaceOptimized(7));
    }

    static class Solution {
        int[] dp;

        /**
         * Time Complexity - O(n)
         * Space Complexity - O(n), only involves space for the DP array
         */
        public int fibonacci(int n) {
            dp = new int[n + 1];

            // base case - set second index with 1, by default dp[0] = 0
            dp[1] = 1;

            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }

            return dp[n];
        }

        /**
         * Time Complexity - O(n)
         * Space Complexity - O(1), we have optimized our solution to use just two constant variables
         */
        public int fibonacciSpaceOptimized(int n) {
            // base case - set 'prev2' with (i-2)th value
            int prev2 = 0;
            // base case - set 'prev1' with (i-1)th value
            int prev1 = 1;

            for (int i = 2; i <= n; i++) {
                int current = prev1 + prev2;
                prev2 = prev1;
                prev1 = current;
            }

            return prev1;
        }
    }
}
