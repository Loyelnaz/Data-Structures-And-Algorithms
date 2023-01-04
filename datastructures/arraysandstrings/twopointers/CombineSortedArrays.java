package datastructures.arraysandstrings.twopointers;

/**
 * Given two sorted integer arrays, return an array that combines both of them and is also sorted.
 */
public class CombineSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1,4,7,10};
        int[] arr2 = {3,5,6};
        int[] result = combineSortedArrays(arr1, arr2);

        for (int ans : result) {
            System.out.print(ans + " ");
        }
    }

    private static int[] combineSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // we would need below two while loops in case
        // we exhausted either one of them in the initial while loop
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }
        return result;
    }
}
