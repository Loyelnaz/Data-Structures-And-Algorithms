package algorithms.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubsequence {
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 3, 4};
        System.out.println(longestIncreasingSubsequence(nums));
    }

    private static int longestIncreasingSubsequence(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, dp(i, nums));
        }
        return result;
    }

    // top-down approach
    private static int dp(int index, int[] nums) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        int result = 1;

        for (int j = 0; j < index; j++) {
            if (nums[index] > nums[j]) {
                result = Math.max(result, dp(j, nums) + 1);
            }
        }

        return result;
    }

    // bottom-up approach
    private static int dp_bottomUp(int index, int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int ans = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp_bottomUp(j, nums) + 1);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }

        return ans;
    }
}
