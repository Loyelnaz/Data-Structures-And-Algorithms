package algorithms.greedy;

import java.util.*;

/**
 * https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/description/
 */
public class LeastNumberOfUniqueNumbers {

    public static void main(String[] args) {
        int[] arr = {4,3,1,1,3,3,2};
        System.out.println(findLeastNumOfUniqueInts(arr, 3));
    }

    /**
     * Time Complexity - O(n * logn)
     * Space Complexity - O(n)
     */
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        // store frequency of each number in a map
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // map.values return a Collection, convert that into a List
        List<Integer> orderedList = new ArrayList<>(map.values());

        orderedList.sort(Comparator.reverseOrder());

        while (k > 0) {
            int value = orderedList.get(orderedList.size() - 1);
            if (value <= k) {
                k -= value;
                orderedList.remove(orderedList.size() - 1);
            } else {
                break;
            }
        }

        return orderedList.size();
    }

}
