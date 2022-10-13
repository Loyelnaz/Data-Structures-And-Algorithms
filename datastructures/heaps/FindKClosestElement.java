package datastructures.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Leetcode - https://leetcode.com/problems/find-k-closest-elements/description/
 */
public class FindKClosestElement {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 4;
        int x = 3;

        List<Integer> result = findClosestElements(nums, k, x);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    //TODO solve this problem using other optimized approaches
    /**
     * Time Complexity - O((n+k)*logK)
     * Space Complexity - O(k)
     */
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> {
            if (Math.abs(n1 - x) == Math.abs(n2 - x)) {
                return n2 - n1;
            }
            return Math.abs(n2 - x) - Math.abs(n1 - x);
        });

        // O(n*logk)
        for (int num : arr) {
            heap.add(num);
            if (heap.size() > k) {
                heap.remove();
            }
        }

        // O(k)
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(heap.remove());
        }

        // O(k*logk)
        Collections.sort(result);
        return result;
    }
}
