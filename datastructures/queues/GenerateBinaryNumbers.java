package datastructures.queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Generate binary numbers from 1 to any given number (n)
 *
 * If n = 3, result = {"1", "10", "11"}
 * If n = 8, result = {"1", "10", "11", "100", "101", "110", "111", "1000"}
 */
public class GenerateBinaryNumbers {
    public static void main(String[] args) {
        String[] result = generateBinary(8);
        printResult(result);
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n) - space would come up to ~2n, after ignoring the constants, it would be O(n)
     */
    private static String[] generateBinary(int number) {
        String[] result = new String[number];
        int count = 0;
        Queue<String> queue = new LinkedList<>();

        // Add "1" to the queue
        queue.add("1");
        while (count < number) {
            result[count] = queue.remove();
            // For every element removed from the queue, append it with "0" and "1"
            queue.add(result[count] + "0");
            queue.add(result[count] + "1");
            count++;
        }

        return result;
    }

    private static void printResult(String[] arr) {
        for (String i : arr) {
            System.out.print(i + " ");
        }
    }
}
