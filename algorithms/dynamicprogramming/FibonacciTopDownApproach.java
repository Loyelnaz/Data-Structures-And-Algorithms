package algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode - https://leetcode.com/problems/fibonacci-number/
 *
 * Calculate the fibonacci of a given number
 *
 * Input: n = 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 *
 * Input: n = 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 */
public class FibonacciTopDownApproach {
    public static void main(String[] args) {
        System.out.println(new Solution().fibonacci(7));
    }

    static class Solution {
        Map<Integer, Integer> memo = new HashMap<>();

        /**
         * With the traditional recursive solution of fibonacci problem i.e. F(n) = F(n-1) + F(n-2),
         * the time complexity is O(2^n) as for every nth fibonacci, we make two more calls to the function
         *
         * With DP approach, the complexity comes down to O(n), which avoids duplicate computation
         */
        public int fibonacci(int n) {
            if (n == 1) {
                return 0;
            }

            if (n == 2) {
                return 1;
            }

            // if the computation is already present in the map, we don't need to calculate it again
            if (memo.containsKey(n)) {
                return memo.get(n);
            }

            memo.put(n, fibonacci(n-1) + fibonacci(n-2));
            return memo.get(n);
        }
    }
}
