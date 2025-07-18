package datastructures.prefixsum;

public class MinimumAverageDifference {
    public static void main(String[] args) {
        int[] arr = {2,5,3,9,5,3};

        System.out.println(minimumAverageDifference(arr));
    }

    //TODO Fix all the test cases
    /**
     *
     */
    public static int minimumAverageDifference(int[] nums) {
        if (nums.length == 1 && nums[0] == 0) {
            return 0;
        }

        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int minIndex = 0;
        long absAverage = 0, minAverage = Integer.MAX_VALUE;
        long leftSum = 0, rightSum = 0;

        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            rightSum = totalSum - leftSum;
            long rightAverage = 0;
            long leftAverage = leftSum / (i + 1);

            if (i != nums.length - 1) {
                rightAverage = rightSum / (nums.length - i - 1);
            }

            absAverage = Math.abs(leftAverage - rightAverage);

            if (absAverage < minAverage) {
                minAverage = absAverage;
                minIndex = i;
            }
        }
        return minIndex;
    }
}
