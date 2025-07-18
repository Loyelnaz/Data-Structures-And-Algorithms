package datastructures.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array arr, count how many elements x there are, such that x + 1 is also in arr.
 * If there are duplicates in arr, count them separately.
 *
 * Input: arr = [1,2,3]
 * Output: 2
 * Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
 *
 * Input: arr = [1,1,3,3,5,5,7,7]
 * Output: 0
 * Explanation: No numbers are counted, cause there is no 2, 4, 6, or 8 in arr.
 */
public class CountingElements {

    public static void main(String[] args) {
        int[] arr = {1,4,3,8,3};

        int result = countingElements(arr);
        System.out.println(result);
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     */
    private static int countingElements(int[] arr) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : arr) {
            numSet.add(num);
        }

        int count = 0;
        for (int num : arr) {
            if (numSet.contains(num + 1)) {
                count++;
            }
        }
        return count;
    }
}
