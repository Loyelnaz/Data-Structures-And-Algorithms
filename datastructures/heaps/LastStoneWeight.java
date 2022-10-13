package datastructures.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Leetcode - https://leetcode.com/problems/last-stone-weight/
 */
public class LastStoneWeight {

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};

        System.out.println(lastStoneWeight(stones));
    }

    /**
     * On each smash, at least one rock is destroyed, so there can be at most 'n' iterations.
     * At each iteration, we perform pops and pushes on the heap, which has a length of 'n' at the start.
     *
     * Time complexity of O(n⋅logn)
     * Space complexity of O(n)
     */
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for (Integer stone : stones) {
            heap.add(stone);
        }

        while (heap.size() > 1) {
            int x = heap.poll();
            int y = heap.poll();

            if (x != y) {
                heap.add(x-y);
            }
        }

        return heap.isEmpty() ? 0 : heap.poll();
    }
}
