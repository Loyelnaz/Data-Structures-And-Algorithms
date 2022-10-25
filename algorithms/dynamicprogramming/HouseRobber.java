package algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode - https://leetcode.com/problems/house-robber/
 *
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 *
 * Below example is one of the edge cases we need to take into account
 * Input: nums = [9,0,0,9]
 * Output: 18
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(new Solution().rob(nums));
    }

    static class Solution {
        /**
         * Time complexity - O(n), where 'n' is the length of the input array, because we only visit each state once.
         * Space complexity - O(1) - space is optimized by taking only two variables to keep track of previous states, instead of an array.
         */
        public int rob(int[] nums) {
            return dp(nums);
        }

        private int dp(int[] nums) {
            // Base case - when 'num' length is either 1 or 2
            if (nums.length == 1) {
                return nums[0];
            }

            int n = nums.length;
            // To reduce space complexity, instead of using an array, we could just use two variables in our case
            // as we are interested in only two of the previous states, and are not dynamically updated the states
            // i.e., dp[3] would need dp[1] and dp[2] for computation
            // dp[0] = nums[0];
            // dp[1] = Math.max(dp[0], nums[1]);
            // we populate dp[0] and dp[1] as our computation would begin from i=2
            int backTwo = nums[0];
            int backOne = Math.max(backTwo, nums[1]);
            if (n == 2) {
                return backOne;
            }

            for (int i = 2; i < n; i++) {
                int temp = backOne;
                // Two possible cases to consider - either we rob or we skip
                // If we rob, we cannot rob the previous house, so the house has to be (i-2)
                // If we skip, we can consider the previous house
                backOne = Math.max(backTwo + nums[i], backOne);
                backTwo = temp;
            }

            return backOne;
        }
    }

    // Implementation using top down DP approach
    static class TopDownSolution {
        Map<Integer, Integer> memo = new HashMap<>();

        public int rob(int[] nums) {
            if (nums.length == 1) {
                // to prevent out of bounds error
                return nums[0];
            }

            return dp(nums.length - 1, nums);
        }

        public int dp(int i, int[] nums) {
            // Base cases
            if (i == 0) {
                return nums[0];
            }
            if (i == 1) {
                return Math.max(nums[0], nums[1]);
            }

            if (memo.containsKey(i)) {
                return memo.get(i);
            }

            // Recurrence relation - O(1)
            memo.put(i, Math.max(dp(i - 1, nums), dp(i - 2, nums) + nums[i]));
            return memo.get(i);
        }
    }
}
