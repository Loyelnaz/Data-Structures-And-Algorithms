package algorithms.dynamicprogramming;

public class FibonacciBottomUpApproach {
    public static void main(String[] args) {
        System.out.println(new FibonacciBottomUpApproach.Solution().fibonacci(7));
    }

    static class Solution {
        int[] dp;

        public int fibonacci(int n) {
            dp = new int[n + 1];
            // base case - set second index as 1, by default dp[1] = 0
            dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }

            return dp[n];
        }
    }
}
