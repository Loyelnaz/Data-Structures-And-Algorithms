package datastructures.stacks;

import java.util.Stack;

/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors.
 * '#' means a backspace character.
 *
 * For example, given s = "ab#c" and t = "ad#c", return true. Because of the backspace, the strings are both equal to "ac".
 *
 * https://leetcode.com/problems/backspace-string-compare/description/
 */
public class BackspaceStringCompare {
    public static final Character BACKSPACE = '#';

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
    }

    public static boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    public static String build(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c != BACKSPACE) {
                stack.push(c);
            } else if (!stack.empty()) {
                stack.pop();
            }
        }

        return String.valueOf(stack);
    }
}
