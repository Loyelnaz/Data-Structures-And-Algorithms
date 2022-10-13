package datastructures.heaps;

import java.util.PriorityQueue;

/**
 * Leetcode - https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
public class KthLargestElementInDataStream {
    PriorityQueue<Integer> heap;
    int k;

    /**
     * Imagine the data stream to be sorted in ascending order. The kth largest would be 'k' elements from the end.
     * If we take max-heap, we would have the largest element at the peek, and we would need to poll 'k' elements.
     *
     * Instead, if we use min heap, and only maintain 'k' elements at every stage, we can access the kth largest element
     * in constant time
     */
    public KthLargestElementInDataStream(int k, int[] nums) {
        heap = new PriorityQueue<>();
        this.k = k;

        for (int num : nums) {
            heap.add(num);

            if (heap.size() > k) {
                heap.poll();
            }
        }
    }

    public int add(int val) {
        heap.add(val);

        if (heap.size() > k) {
            heap.poll();
        }

        return heap.peek();
    }
}
