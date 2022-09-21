package datastructures.stack;

/**
 * Problem - https://www.codingninjas.com/codestudio/problems/two-stacks_983634
 *
 * Approach 1: divide the array into two halves, first half (0 to n/2) would be used by the stack1,
 *              and second half (n/2+1 to n-1) would be used by the stack2. Lets say, stack1 is already
 *              occupied completely and stack2 still has some space left, further push operations on
 *              stack1 could not be performed as the space assigned for stack1 is already occupied.
 *              In this approach, the space is not used optimally.
 *
 * Approach 2: Start pushing stack1 elements to the beginning of the array, and stack2 elements to the
 *             end of the array. This way we would utilize the space well.
 */
public class TwoStack {
    int[] arr;
    int peek1;
    int peek2;

    // Initialize TwoStack.
    public TwoStack(int s) {
        // Write your code here
        arr = new int[s];
        peek1 = -1;
        peek2 = s;
    }

    // Push in stack 1.
    public void push1(int num) {
        // Write your code here
        if (peek2 - peek1 > 1 && peek1 != arr.length-1) {
            arr[++peek1] = num;
        }
    }

    // Push in stack 2.
    public void push2(int num) {
        // Write your code here
        if (peek2 - peek1 > 1 && peek2 >= 0) {
            arr[--peek2] = num;
        }
    }

    // Pop from stack 1 and return popped element.
    public int pop1() {
        // Write your code here
        return peek1 != -1 ? arr[peek1--] : -1;
    }

    // Pop from stack 2 and return popped element.
    public int pop2() {
        // Write your code here
        return peek2 != arr.length ? arr[peek2++] : -1;
    }
}
