package datastructures.patterns.slidingwindow;

public class MaximumAverageSubarray {
    public static void main(String[] args) {
        int[] arr = {100,200,300,400,500};
        int k = 2;

        System.out.print(findMaxAverage(arr, k));
    }

    //TODO test for other corner cases
    /**
     * Time complexity : O(n)O(n). We iterate over the given numsnums array of length nn once only.
     * Space complexity : O(1)O(1). Constant extra space is used.
     */
    public static double findMaxAverage(int[] nums, int k) {
        double currentSum = 0;
        for(int i=0; i<k; i++)
            currentSum += nums[i];

        double maxSum = currentSum;
        for(int i=k; i<nums.length; i++){
            currentSum += nums[i] - nums[i-k];
            maxSum = Math.max(maxSum,currentSum);
        }

        return maxSum/k;
    }
}
