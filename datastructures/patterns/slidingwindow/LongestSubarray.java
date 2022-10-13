package datastructures.patterns.slidingwindow;

public class LongestSubarray {
    public static void main(String[] args) {
        int[] arr = {3,1,2,7,4,2,1,1,5};
        int k = 8;

        System.out.print(longestSubarray(arr, k));
    }

    /**
     *Given a subarray starting at left and ending at right, the length is right - left + 1.
     * As mentioned before, this algorithm has a time complexity of O(n) since all work done inside the for loop is O(1).
     * The space complexity is constant because we are only using 3 integer variables.
     */
    public static int longestSubarray(int[] arr, int k) {
        int maxLength = 0;
        int left = 0, currentSum = 0;

        for (int right = 0; right < arr.length; right++) {
            currentSum += arr[right];
            while (currentSum > k) {
                currentSum -= arr[left];
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
        }

        return maxLength;
    }
}
