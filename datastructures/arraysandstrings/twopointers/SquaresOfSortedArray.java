package datastructures.arraysandstrings.twopointers;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/discussion/
 *
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 */
public class SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] arr = {-4,-1,0,3,10};

        int[] result = sortedSquares(arr);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    /**
     * We can use two pointers approach to solve this problem in O(n) since the array is sorted
     * If we have negative integers on one side, and positive on the other side,
     * we can use left and right indices to track that.
     *
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1, i = n - 1;

        while (left <= right) {
            int square;
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                square = nums[right];
                right--;
            } else {
                square = nums[left];
                left++;
            }
            result[i--] = square * square;
        }
        return result;
    }
}
