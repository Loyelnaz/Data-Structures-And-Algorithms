package datastructures.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a 2D array nums that contains n arrays of distinct integers,
 * return a sorted array containing all the numbers that appear in all n arrays.
 *
 * For example, given nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]], return [3, 4].
 * 3 and 4 are the only numbers that are in all arrays.
 */
public class IntersectionOfArrays {

    public static void main(String[] args) {
        int[][] arr = {{3,1,2,4,5},{1,2,3,4},{3,4,5,6}};

        List<Integer> result = calculateIntersectedArray(arr);
        System.out.println(result);
    }

    /**
     * Time complexity : O(n * m)
     * Space complexity : O(n * m), if every element in the arrays is unique
     */
    private static List<Integer> calculateIntersectedArray(int[][] arr) {
        Map<Integer, Integer> counts = new HashMap<>();

        // If each list has "m" elements, it takes us O(n * m) to iterate over them
        for (int[] innerArray : arr) {
            for (int num : innerArray) {
                counts.put(num, counts.getOrDefault(num, 0) + 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        int arraySize = arr.length;
        for (int key : counts.keySet()) {
            // The problem states that each individual array contains distinct integers.
            // This means that a number appears n times if and only if it appears in all arrays.
            if (counts.get(key) == arraySize) {
                result.add(key);
            }
        }

        return result;
    }
}
