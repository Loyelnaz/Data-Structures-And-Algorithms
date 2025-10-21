package algorithms.dynamicprogramming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-common-subsequence/description/
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(0, 0, text1, text2, memo);
    }

    private static int dp(int i, int j, String text1, String text2, int[][] memo) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }

        // if you have already visited and calculated for the (i, j) pair
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // case 1: both the characters are matching
        // consider them both and move to the next set of characters
        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + dp(i + 1, j + 1, text1, text2, memo);
        } else {
            // case 2: both the character do not match
            // pick either character from text1 or from test2
            memo[i][j] = Math.max(dp(i + 1, j, text1, text2, memo), dp(i, j + 1, text1, text2, memo));
        }

        return memo[i][j];
    }
}
