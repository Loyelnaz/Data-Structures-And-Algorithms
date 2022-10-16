package datastructures.stacks;

import java.util.Stack;

/**
 * Sort all the elements in the stack in an ascending order
 *
 * Input - {5,3,1,6,2,4}
 * Output - {1,2,3,4,5,6}
 */
public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(5);
        stack.add(3);
        stack.add(1);
        stack.add(6);
        stack.add(2);
        stack.add(4);

        sortStack(stack);
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    /**
     * Approach:
     *         Use a temporary stack
     *         Pop an element from the main stack
     *         Compare it with the top of the temp stack. If it's greater than equal to, we push the elements,
     *         Otherwise, we pop all the elements from the temp stack until we match the greater than equal to criteria
     *
     * Time Complexity - O(n^2) - as both inner and outer loop traverse through all the N elements
     */
    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();

        while (!stack.empty()) {
            int poppedElement = stack.pop();

            if (!tempStack.empty() && poppedElement < tempStack.peek()) {
                // pop all the elements from the temp stack until we find an elements lesser than the popped element
                while (!tempStack.empty() && poppedElement < tempStack.peek()) {
                    stack.push(tempStack.pop());
                }
            }
            tempStack.push(poppedElement);
        }

        // elements would be in descending order in the temp stack
        // Move all those into the main stack
        while (!tempStack.empty()) {
            stack.push(tempStack.pop());
        }
    }
}
