package algorithms.dynamicprogramming;

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
}
