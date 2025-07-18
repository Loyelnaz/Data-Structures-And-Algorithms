package datastructures.stacks;

/**
 * https://leetcode.com/problems/make-the-string-great/description/
 */
public class MakeStringGreat {
    public static void main(String[] args) {
        System.out.println(makeGood("leEeetcode"));
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    public static String makeGood(String s) {
        // Use stack to store the visited characters.
        StringBuilder stack = new StringBuilder("");
        for (Character ch : s.toCharArray()) {
            // If the current character make a pair with the last character in the stack,
            // remove both of them. Otherwise, we the add current character to stack.
            if (stack.length() > 0 && Math.abs(stack.charAt(stack.length() - 1) - ch) == 32) {
                stack.deleteCharAt(stack.length() - 1);
            } else {
                stack.append(ch);
            }
        }

        return stack.toString();
    }
}
