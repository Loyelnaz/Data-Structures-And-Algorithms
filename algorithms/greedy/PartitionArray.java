package algorithms.greedy;

import java.util.Arrays;

/**
 * Given an integer array nums and an integer k, split nums into subsequences,
 * where each subsequences' maximum and minimum element is within k of each other.
 * What is the minimum number of subsequences needed?
 *
 * For example, given nums = [3, 6, 1, 2, 5] and k = 2, the answer is 2. The subsequences are [3, 1, 2] and [6, 5].
 *
 * https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/description/
 */
public class PartitionArray {

    public static void main(String[] args) {
        int[] nums = {3,6,1,2,5};
        int k = 2;

        System.out.println(partitionArray(nums, k));
    }

    /**
     * Time Complexity - O(nlogn)
     * Space Complexity - O(n), as Java uses Timsort
     */
    public static int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int x = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - x > k) {
                x = nums[i];
                count++;
            }
        }
        return count;
    }
}
