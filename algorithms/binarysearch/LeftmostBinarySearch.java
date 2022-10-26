package algorithms.binarysearch;

/**
 * Find leftmost index of the target if it exists in the array
 *
 * Input - arr = {1,2,2,2,2,4,5,6}, key = 2
 * Output - 1
 */
public class LeftmostBinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,6,9};
        int key = 3;
        System.out.println(binarySearch(arr, key));
    }

    /**
     * Time Complexity - O(logn)
     */
    private static int binarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;

            if (arr[middle] < key) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }
}
