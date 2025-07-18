package datastructures.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, find all the numbers x in nums that satisfy the following: x + 1 is not in nums, and x - 1 is not in nums.
 *
 * If a valid number x appears multiple times, you only need to include it in the answer once.
 */
public class FindNumbers {
    public static void main(String[] args) {
        int[] arr = {1,4,3,7,2};

        Set<Integer> result = findNumbers(arr);
        System.out.print(result);
    }

    /**
     * The brute force approach is to use nested loop, but this would take O(n^2).
     *
     * Instead, use hashmap, map index as value to (target-num) as key
     *
     * Time complexity : O(n) as the hash set operation uses O(1)
     * Space complexity : O(n)
     */
    private static Set<Integer> findNumbers(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        Set<Integer> result = new HashSet<>();
        for (int num : numSet) {
            if (!numSet.contains(num + 1) && !numSet.contains(num - 1)) {
                result.add(num);
            }
        }
        return result;
    }
}
