package datastructures.arraysandstrings.slidingwindow;

/**
 * Given an integer array nums and an integer k,
 * find the sum of the subarray with the largest sum whose length is k
 *
 * For example, nums = {3, -1, 4, 12, -8, 5, 6}, k = 4
 * The answer would be 18 and the subarray would be {3, -1, 4, 12}
 */
public class LargestSumOfSubarrayOfLengthK {
    public static void main(String[] args) {
        int[] nums = {3, -1, 4, 12, -8, 5, 6};
        int k = 4;

        System.out.println(findLargestSubarray(nums, k));
    }

    /**
     * This problem can be solved using fixed sliding window pattern
     *
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public static int findLargestSubarray(int[] nums, int k) {
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        int largestSum = currentSum;
        for (int i = k; i < nums.length; i++) {
            // as we add up the current kth element of the window,
            // we will also need to subtract the previous 0th index element of the windex
            currentSum += nums[i] - nums[i - k];
            largestSum = Math.max(largestSum, currentSum);
        }

        return largestSum;
    }
}
