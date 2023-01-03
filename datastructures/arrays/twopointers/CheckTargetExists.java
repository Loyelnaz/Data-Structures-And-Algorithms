package datastructures.arrays.twopointers;

/**
 * Given a sorted array of unique integers and a target integer,
 * return true if there exists a pair of numbers that sum to target, false otherwise.
 *
 * For example, given nums = [1, 2, 4, 6, 8, 9, 14, 15] and target = 13, return true because 4 + 9 = 13.
 */
public class CheckTargetExists {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6, 8, 9, 14, 15};
        int target = 13;
        System.out.println(checkForTarget(nums, target));
    }

    /**
     * Time Complexity - O(n), brute force would take O(n^2)
     * Space Complexity - O(1)
     */
    public static boolean checkForTarget(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int currentSum = nums[start] + nums[end];
            if (currentSum == target) {
                return true;
            }

            // since the array is sorted, moving start and end index
            // based on the currentSum would either increase or decrease the sum
            if (currentSum > target) {
                end--;
            } else {
                start++;
            }
        }

        return false;
    }
}
