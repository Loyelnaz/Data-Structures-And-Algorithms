package datastructures.heaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Leetcode - https://leetcode.com/problems/top-k-frequent-elements/description/
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1,1,2,1,3,2};
        int k = 2;

        int[] result = topKFrequent(nums, k);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    //TODO solve this problem using bucket sort
    /**
     * Time complexity of O(n⋅logk)
     * Space complexity of O(n)
     */
    public static int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }

        // store the frequency of elements in a hashmap
        // Time - O(n), Space - O(n)
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        // Create a heap based on the frequencies stored in the hashmap
        // Time - O(n*logk), Space - O(n)
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(frequency::get));
        for (int key : frequency.keySet()) {
            heap.add(key);
            if (heap.size() > k) {
                heap.remove();
            }
        }

        // Add top 'k' elements into the result
        // Time - O(k*logk), Space - O(1)
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.remove();
        }

        return result;
    }
}
