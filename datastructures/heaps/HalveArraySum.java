package datastructures.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem - https://leetcode.com/problems/minimum-operations-to-halve-array-sum/description/
 */
public class HalveArraySum {

    public static void main(String[] args) {
        int[] nums = {5,19,8,1};

        System.out.println(halveArray(nums));
    }

    /**
     * To minimize the steps, we would want to maximize the amount we reduce at each step i.e.,
     * choose the largest element.
     * Time Complexity - O(n*logn) - each iteration takes O(logn) heap operations,
     * and the number of operations needed is 'n'
     */
    public static int halveArray(int[] nums) {
        PriorityQueue<Double> heap = new PriorityQueue<>(Comparator.reverseOrder());
        double target = 0;

        for (double num : nums) {
            heap.add(num);
            target += num;
        }

        target /= 2;
        int operationCount = 0;

        while (target > 0) {
            double heapElement = heap.poll();
            target -= (heapElement/2);
            heap.add(heapElement/2);
            operationCount++;
        }

        return operationCount;
    }
}
