package datastructures.arraysandstrings.slidingwindow;

/**
 * Given an array of positive integers nums and an integer k,
 * find the length of the longest subarray whose sum is less than or equal to k
 *
 * Input - nums = [3, 1, 2, 7, 4, 2, 1, 1, 5], k = 8
 * Output - 4 [4, 2, 1, 1]
 */
public class LongestSubarraySumLessThanK {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 7, 4, 2, 1, 1, 5};
        int k = 8;

        System.out.println(findLongestSubarray(nums, k));
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    private static int findLongestSubarray(int[] nums, int k) {
        int left = 0;
        int currentSum = 0, maxLength = 0;

        // time - O(n)
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            // time - O(n) - this would be amortized since
            // if in one iteration we traverse all 'n' elements,
            // in the next iterations, we wouldn't move further
            while (currentSum > k) {
                currentSum -= nums[left++];
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
