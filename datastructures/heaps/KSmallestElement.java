package datastructures.heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Find the 'k' smallest elements in the array
 *
 * Input: arr = [9,4,7,1,-3,6,5], k = 3
 * Output: [-3,1,4]
 */
public class KSmallestElement {
    public static void main(String[] args) {
        int[] arr = {1,4,7,12,15,14,9};
        System.out.println(Arrays.toString(findKSmallest(arr, 3)));
    }

    // O(n+klogk)
    public static int[] findKSmallest(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int[] result = new int[k];

        // O(n) - to add each element of the array
        for (int i : arr) {
            queue.add(i);

            // only keep 'k' elements in the queue at a given time
            if (queue.size() > k) {
                queue.poll();
            }
        }

        // O(klogk) - Removes the smallest element and heapify's
        while (!queue.isEmpty()) {
            result[--k] = queue.poll();
        }
        return result;
    }
}
