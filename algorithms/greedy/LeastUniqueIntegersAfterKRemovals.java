package algorithms.greedy;

import java.util.*;

/**
 * https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/description/
 */
public class LeastUniqueIntegersAfterKRemovals {
    public static void main(String[] args) {
        int[] arr = {4,3,1,1,3,3,2};
        int k = 3;

        System.out.println(findLeastNumOfUniqueInts(arr, k));
    }

    /**
     * Time Complexity - O(nlogn)
     * Space Complexity - O(n)
     */
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : arr) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        List<Integer> ordered = new ArrayList<>();
        for (int val: counts.values()) {
            ordered.add(val);
        }

        Collections.sort(ordered);

        while (k > 0) {
            int value = ordered.get(0);
            if (value <= k) {
                k -= value;
                ordered.remove(0);
            } else {
                break;
            }
        }

        return ordered.size();
    }
}
