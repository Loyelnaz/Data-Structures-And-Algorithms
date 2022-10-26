package algorithms.binarysearch;

/**
 * Leetcode - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * Given an array of integers nums sorted in non-decreasing order,
 * find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 */
public class FirstAndLastPositionOfElement {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,6,9};
        int key = 3;
        int[] result = searchRange(arr, key);
        System.out.println("{" + result[0] + ", " + result[1] + "}");
    }

    public static int[] searchRange(int[] nums, int target) {
        int firstPosition = binarySearch(nums, target, true);

        if (firstPosition == -1) {
            return new int[]{-1, -1};
        }

        int lastPosition = binarySearch(nums, target, false);

        return new int[]{firstPosition, lastPosition};
    }

    /**
     * To differentiate between left most and right most element search,
     * we are using 'isFirst' boolean to track that
     *
     * Time Complexity - O(logn)
     */
    private static int binarySearch(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                if (isFirst) {
                    // we found our left most element
                    if (middle == left || nums[middle - 1] != target) {
                        return middle;
                    }

                    // search to the left
                    right = middle - 1;
                } else {
                    if (middle == right || nums[middle + 1] != target) {
                        return middle;
                    }

                    // search to the right
                    left = middle + 1;
                }
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }
}
