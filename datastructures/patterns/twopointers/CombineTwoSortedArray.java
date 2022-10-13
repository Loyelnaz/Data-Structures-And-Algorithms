package datastructures.patterns.twopointers;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two sorted integer arrays, return an array that combines both of them and is also sorted.
 */
public class CombineTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1,1,4,6,9};
        int[] arr2 = {0,3,5,7};

        List<Integer> resultArray = combineSortedArrays(arr1, arr2);
        for (int i = 0; i < resultArray.size(); i++) {
            System.out.print(resultArray.get(i) + " ");
        }
    }

    /**
     * The trivial approach would be to first combine both input arrays and then perform a sort.
     * If we have n = arr1.length + arr2.length, then this gives a time complexity of O(n*logn).
     *
     * This would be a good approach if the input arrays were not sorted,
     * but because they are sorted, we can use the two-pointers technique to improve to O(n).
     */
    private static List<Integer> combineSortedArrays(int[] arr1, int[] arr2) {
        int index1 = 0, index2 = 0;
        List<Integer> result = new ArrayList<>();

        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] < arr2[index2]) {
                result.add(arr1[index1++]);
            } else {
                result.add(arr2[index2++]);
            }
        }

        while (index1 < arr1.length) {
            result.add(arr1[index1++]);
        }

        while (index2 < arr2.length) {
            result.add(arr2[index2++]);
        }

        return result;
    }
}
