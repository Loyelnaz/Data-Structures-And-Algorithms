package algorithms.binarysearch;

/**
 * Find pivot element of a sorted and rotated array
 *
 * Input - arr = {4, 5, 6, 7, 8, 1, 2, 3}
 * Output - 1
 */
public class PivotIndexOfSortedRotatedArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,1,2,3};
        System.out.println(pivotElement(arr));
    }

    private static int pivotElement(int[] arr) {
        int left = 0, right = arr.length - 1;

        if (left == right) {
            return arr[left];
        }

        while (left <= right) {
            int middle = left + (right - left) / 2;

            // check if pivot element criteria is satisfied, i.e.,
            // arr[mid-1] > arr[mid] < arr[mid+1]
            if (arr[middle] < arr[middle - 1] && arr[middle] < arr[middle + 1]) {
                return arr[middle];
            }

            if (arr[left] <= arr[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return arr[left];
    }
}
