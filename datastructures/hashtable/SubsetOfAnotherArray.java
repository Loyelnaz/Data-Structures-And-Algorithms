package datastructures.hashtable;

import java.util.HashSet;

/**
 * Check whether a given array is a subset of another array. Return true if arr2 is a subset of arr1
 *
 * Input: arr1 = {1,4,2,5,6}, arr2 = {2,5,4}
 * Output: true
 */
public class SubsetOfAnotherArray {
    public static void main(String[] args) {
        int[] arr1 = {1,4,3,7,2};
        int[] arr2 = {4,2,7};

        System.out.println(isSubset(arr1, arr2));
    }

    // Time - O(m+n), loops over both the arrays
    public static boolean isSubset(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            if (!set.contains(arr1[i])) {
                set.add(arr1[i]);
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            if (!set.contains(arr2[i])) {
                return false;
            }
        }

        return true;
    }
}
