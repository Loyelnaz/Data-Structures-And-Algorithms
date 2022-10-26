package algorithms.binarysearch;

import java.util.Arrays;
import java.util.List;

/**
 * Given a sorted integer array, nums, and an integer value, target, the array is rotated by some arbitrary number.
 * Search and return the index of target in this array. If the target does not exist, return -1.
 */
public class SearchInSortedRotatedArray {
    public static void main(String args[]) {
        List<Integer> targetList = Arrays.asList(3, 6, 3, 6);
        List<List<Integer>> numList = Arrays.asList(
                Arrays.asList(6, 7, 1, 2, 3, 4, 5),
                Arrays.asList(6, 7, 1, 2, 3, 4, 5),
                Arrays.asList(4, 5, 6, 1, 2, 3),
                Arrays.asList(4, 5, 6, 1, 2, 3)
        );

        for (int i = 0; i < targetList.size(); i++) {
            System.out.println((i + 1) + ".\tSorted array: " + numList.get(i) + "\n\ttarget " + targetList.get(i)
                    + " found at index " + binarySearchRotated(numList.get(i), targetList.get(i)));
        }
    }

    /**
     * Time complexity - O(logn)
     * Space complexity - O(1)
     */
    public static int binarySearchRotated(List<Integer> nums, int target) {
        int start = 0;
        int end = nums.size() - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Target value is present at the middle of the array
            if (nums.get(mid) == target)
                return mid;

            // start to mid is sorted
            if (nums.get(start) < nums.get(mid)) {
                if (nums.get(start) <= target && target < nums.get(mid)) {
                    end = mid - 1; // target is within the sorted first half of the array
                }
                else start = mid + 1; // target is not within the sorted first half,
                                      // so let’s examine the unsorted second half
            }
            // mid to end is sorted
            else {
                if (nums.get(mid) < target && target <= nums.get(end))
                    start = mid + 1; // target is within the sorted second half of the array
                else
                    end = mid - 1; // target is not within the sorted second half,
                                   // so let’s examine the unsorted first half
            }
        }
        return -1;
    }
}
