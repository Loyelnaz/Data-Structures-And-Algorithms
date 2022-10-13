package datastructures.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',determine if the input string is valid.
 * The string is valid if all open brackets are closed by the same type of closing bracket in the correct order,
 * and each closing bracket closes exactly one open bracket.
 *
 * For example, s = "({})" and s = "(){}[]" are valid, but s = "(]" and s = "({)}" are not valid.
 *
 * Problem - https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("({[}])"));
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n) - worst case if all the characters are opening parentheses
     */
    public static boolean isValid(String s) {
        Map<Character, Character> matching = new HashMap<>();
        matching.put('(', ')');
        matching.put('{', '}');
        matching.put('[', ']');

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            // Check if it's an opening parentheses
            if (matching.containsKey(ch)) {
                stack.push(ch);
            } else {
                if (stack.empty()) {
                    return false;
                }

                char previousOpening = stack.pop();
                // Check if top of the stack (which is an opening parentheses) matches with the current closing parentheses
                if (matching.get(previousOpening) != ch) {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
