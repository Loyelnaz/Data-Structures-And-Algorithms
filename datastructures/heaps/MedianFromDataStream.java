package datastructures.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Leetcode - https://leetcode.com/problems/find-median-from-data-stream/
 */
public class MedianFromDataStream {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFromDataStream() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    /**
     * Below is the algorithm for the problem:
     * 1. Push num onto the max heap (as mentioned above we arbitrarily chose the max heap).
     * 2. Pop from the max heap, and push that element onto the min heap.
     * 3. After step 2, if the min heap has more elements than the max heap, pop from the min heap and push the result onto the max heap.
     */
    public void addNum(int num) {
        maxHeap.add(num);
        // we remove from the max heap so that all the elements in the min heap are larger than
        // or equal to all the elements in the max heap
        minHeap.add(maxHeap.remove());
        // This is to have max heap store the extra element if there are an odd number of elements.
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.remove());
        }
    }

    public double findMedian() {
        // this is to return only one element in the case of odd numbered data stream
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
