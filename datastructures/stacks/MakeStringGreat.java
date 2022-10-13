package datastructures.stacks;

import java.util.Stack;

/**
 * https://leetcode.com/problems/make-the-string-great/description/
 */
public class MakeStringGreat {
    public static void main(String[] args) {
        System.out.println(makeGood("leEeetcode"));
    }

    /**
     * Time - O(n), Space - O(n)
     */
    public static String makeGood(String s) {
        // Use stack to store the visited characters.
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            // If the current character make a pair with the last character in the stack,
            // remove both of them. Otherwise, we the add current character to stack.
            if (!stack.empty() && Math.abs(stack.peek() - ch) == 32) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.empty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }
}
