package datastructures.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of two numbers such that they add up to target.
 * You cannot use the same index twice.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {1,4,3,7,2};
        int target = 6;

        int[] result = twoSum(arr, target);
        System.out.println("Indices are " + result[0] + " and " + result[1]);
    }

    /**
     * The brute force approach is to use nested loop, but this would take O(n^2).
     *
     * Instead, use hashmap, map index as value to (target-num) as key
     *
     * Time complexity : O(n) as the hash map operation uses O(1)
     * Space complexity : O(n)
     */
    public static int[] twoSum(int[] arr, int target) {
        // If the question wanted us to return a boolean indicating
        // if a pair exists or to return the numbers themselves,
        // then we could just use a set.
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int complement = target - num;
            if (hashMap.containsKey(complement)) {
                return new int[] {hashMap.get(complement), i};
            }
            hashMap.put(num, i);
        }

        return new int[] {-1, -1};
    }
}
