package datastructures.patterns.slidingwindow;

/**
 * Given an integer array nums and an integer k, find the sum of the subarray with the largest sum whose length is k
 */
public class LargestSubarraySum {
    public static void main(String[] args) {
        int[] arr = {100,200,300,400,500};
        int k = 2;

        System.out.print(largestSubarraySum(arr, k));
    }

    /**
     * we can build a window of length k and then slide it along the array.
     * Add and remove one element at a time to make sure the window stays size k.
     * If we are adding the value at i, then we need to remove the value at i - k.
     */
    public static int largestSubarraySum(int[] arr, int k) {
        int currentSum = 0, maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i >= k) {
                currentSum -= arr[i-k];
            }
            currentSum += arr[i];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
