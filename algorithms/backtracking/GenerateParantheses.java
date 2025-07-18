package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 *
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParantheses {

    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);
        System.out.println(result);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(""), result);
        return result;
    }

    private static void backtrack(int n, int leftCount, int rightCount, StringBuilder currString, List<String> result) {
        if (currString.length() == 2 * n) {
            result.add(currString.toString());
            return;
        }

        if (leftCount < n) {
            currString.append("(");
            backtrack(n, leftCount + 1, rightCount, currString, result);
            currString.deleteCharAt(currString.length() - 1);
        }

        if (leftCount > rightCount) {
            currString.append(")");
            backtrack(n, leftCount, rightCount + 1, currString, result);
            currString.deleteCharAt(currString.length() - 1);
        }
    }
}
