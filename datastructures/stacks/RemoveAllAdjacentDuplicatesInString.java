package datastructures.stacks;

import java.util.Stack;

/**
 * You are given a string s. Continuously remove duplicates (two of the same character beside each other) until you can't anymore.
 * Return the final string after this.
 *
 * For example, given s = "abbaca", you can first remove the "bb" to get "aaca".
 * Next, you can remove the "aa" to get "ca". This is the final answer.
 */
public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    /**
     * If we take the example of "abbcca", though we know "aa" are potential duplicates,
     * we will still remove characters in c->b->a order. This falls under LIFO pattern.
     *
     * Time - O(n), Space - O(n)
     */
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            // compare current character with the top of the stack
            // If they match, remove the element from the stack. Basically, remove the duplicates
            if (!stack.empty() && stack.peek() == ch) {
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
