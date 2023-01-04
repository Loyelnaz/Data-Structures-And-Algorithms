package datastructures.arraysandstrings.slidingwindow;

/**
 * Given an array of positive integers nums and an integer k,
 * return the number of contiguous subarrays where the product
 * of all the elements in the subarray is strictly less than k.
 *
 * For example, given the input nums = [10, 5, 2, 6], k = 100,
 * the answer is 8. The subarrays with products less than k are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 */
public class NumberOfSubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    /**
     * Hint - Whenever we have a problem asking for the number of subarrays,
     * think of this: at each index, how many valid subarrays end at this index?
     *
     * Valid subarrays in this case would be subarrays having product less than k
     *
     * Let's split the 8 subarrays by their ending indices:
     * index 0 = [10]
     * index 1 = [5], [10, 5]
     * index 2 = [2], [5, 2]
     * index 3 = [6], [2, 6], [5, 2, 6]
     *
     * For each index, the number of subarrays ending at that index
     * is the length of the window after reaching that index.
     *
     * For any given ending index right, a subarray could start at any index between left and right,
     * which is a total of right - left + 1 (the window size) starting indices.
     *
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        // handle edge case, where k = 0 or negative
        if (k < 1) {
            return 0;
        }

        int left = 0, currentProduct = 1;
        int result = 0;

        for (int right = 0; right < nums.length; right++) {
            currentProduct *= nums[right];

            // if the currentProduct doesn't fall into our constraint,
            // we move the left index until the constraint is satisfied
            while (left <= right && currentProduct >= k) {
                currentProduct /= nums[left];
                left++;
            }

            // since we already know how many subarrays are possible at a given index,
            // we just add up based on the right and left index
            result += (right - left + 1);
        }

        return result;
    }
}
