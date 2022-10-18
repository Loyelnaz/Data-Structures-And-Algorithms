package datastructures.stacks;

import java.util.Stack;

/**
 * Given an array, find the next greater element of each index. If there is no greater element, then use -1
 *
 * Input - {4,2,5,7,6,9}
 * Output - {5,5,7,9,9,-1}
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {4,2,5,7,6,9};
        int[] result = nextGreaterElement(arr);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    /**
     * Time Complexity - O(n)
     */
    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.empty() && arr[i] > stack.peek()) {
                stack.pop();
            }

            if (stack.empty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            stack.push(arr[i]);
        }
        return result;
    }
}
