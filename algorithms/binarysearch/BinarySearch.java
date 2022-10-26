package algorithms.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        // More test cases to try out
//        int[] arr = {3, 7, 11, 13, 19, 27};
//        int[] arr = {3, 7, 11, 13, 19, 20};
        int[] arr = {3, 7, 11, 19, 27};
        int key = 27;
        System.out.println(binarySearch(arr, key));
    }

    // Complexity would O(logN)
    private static int binarySearch(int[] arr, int key) {
        int start = 0, end = arr.length - 1;
        int index = -1;
        while (start <= end) {
            // If start and end are of 2^31-1 size, then the addition would
            // result in bigger number exceeding the integer limits
            // int mid = (start + end) / 2;

            // Modify it such that we avoid addition of these two numbers
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else if (arr[mid] > key) {
                end = mid - 1;
            }
        }

        return index;
    }
}
