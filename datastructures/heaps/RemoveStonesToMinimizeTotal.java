package datastructures.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Leetcode - https://leetcode.com/problems/remove-stones-to-minimize-the-total/description/
 */
public class RemoveStonesToMinimizeTotal {
    public static void main(String[] args) {
        int[] piles = {4,3,6,7};
        int k = 3;

        System.out.println(minStoneSum(piles, k));
    }

    /**
     * Time complexity of O(k⋅logn)
     * Space complexity of O(n)
     */
    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        int totalStones = 0;

        for (int stones : piles) {
            heap.add(stones);
            totalStones += stones;
        }

        for (int i = 0; i < k; i++) {
            int maxElement = heap.remove();
            int stonesRemoved = maxElement / 2;
            totalStones -= stonesRemoved;

            heap.add(maxElement - stonesRemoved);
        }

        return totalStones;
    }
}
