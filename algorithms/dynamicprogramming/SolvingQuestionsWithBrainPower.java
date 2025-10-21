package algorithms.dynamicprogramming;

/**
 * https://leetcode.com/problems/solving-questions-with-brainpower/description/
 */
public class SolvingQuestionsWithBrainPower {
    public static void main(String[] args) {
        int[][] questions = {{1,1}, {2,2}, {3,3}, {4,4}, {5,5}};
        long result = mostPoints(questions);
        System.out.println(result);
    }

    // Bottom Up Approach
    public static long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int j = i + questions[i][1] + 1;
            // Recurrence Relation -> max(questions[i][0] + dp(j), dp(i + 1), where j = i + questions[i][1] + 1
            dp[i] = Math.max(questions[i][0] + dp[Math.min(j, n)], dp[i + 1]);
        }
        return dp[0];
    }

    // Top Down Approach
    private long dp(int index, int[][] questions) {
        if (index >= questions.length) {
            return 0;
        }

        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        int points = questions[index][0];
        int brainpower = questions[index][1];
        int j = brainpower + index + 1;
        memo.put(index, Math.max(points + dp(j, questions), dp(index + 1, questions)));
        return memo.get(index);
    }
}
