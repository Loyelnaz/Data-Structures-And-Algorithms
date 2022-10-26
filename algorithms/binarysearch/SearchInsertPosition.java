package algorithms.binarysearch;

/**
 * Leetcode - https://leetcode.com/problems/search-insert-position/description/
 *
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,6,9};
        int key = 10;
        System.out.println(searchInsert(arr, key));
    }

    public static int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target);
    }

    private static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return middle;
            }

            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return left;
    }
}
