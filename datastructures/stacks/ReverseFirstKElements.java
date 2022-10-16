package datastructures.stacks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Reverse the first K elements in the queue
 *
 * Input: queue={1,2,3,4,5,6,7}, k=4
 * Output: result={4,3,2,1,5,6,7}
 */
public class ReverseFirstKElements {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        reverseK(queue, 4);
        while(!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
    }

    /**
     * Approach:
     *          Push first k elements in queue in a stack
     *          Pop Stack elements and enqueue them at the end of queue
     *          Dequeue queue elements till "queue.size() - k" and append them at the end of queue
     *
     * Time Complexity - O(n)
     */
    public static void reverseK(Queue<Integer> queue, int k) {
        if (queue.isEmpty() || k == 0) {
            return;
        }

        Stack<Integer> stack = new Stack<>();
        int count = 0;

        // Push first 'k' elements into a stack - takes O(k)
        while (count < k) {
            stack.push(queue.remove());
            count++;
        }

        // Pop stack elements and add them to the end of the queue - takes O(k)
        while (!stack.empty()) {
            queue.add(stack.pop());
        }

        // Remove 'n-k' elements and add them to the end of the queue - taken O(n-k),
        // but since we looped through all the queue elements previously, it is safe to say it takes O(n)
        for (int i = 0; i < queue.size() - k; i++) {
            queue.add(queue.remove());
        }
    }
}
