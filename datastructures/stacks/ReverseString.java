package datastructures.stacks;

import java.util.Stack;

/**
 * Reverse a string using stack
 */
public class ReverseString {
    public static void main(String[] args) {
        String input = "abcde";
        System.out.println(reverseString(input));
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     * @param input
     * @return
     */
    private static String reverseString(String input) {
        java.util.Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        StringBuilder result = new StringBuilder();
        while (!stack.empty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }
}
