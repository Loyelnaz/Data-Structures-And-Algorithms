package datastructures.hashing;

import java.util.HashMap;

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
     * Time complexity : O(1)
     * Space complexity : O(n)
     */
    public static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        for(int i=0; i < target; i++) {
            if (hashMap.containsKey(arr[i])) {
                return new int[] {hashMap.get(arr[i]), i};
            }
            hashMap.put(target-arr[i], i);
        }

        return new int[] {-1, -1};
    }
}
