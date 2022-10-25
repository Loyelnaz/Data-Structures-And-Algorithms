package algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode - https://leetcode.com/problems/permutations/description/
 *
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 *
 * Input: nums = [1]
 * Output: [[1]]
 */
public class PermutationOfArrayElements {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(Arrays.asList(permute(nums)));
    }

    /**
     * Time Complexity - O(n.n!)
     * n! because initial backtrack makes 'n' calls, then 'n-1', followed by 'n-2', making it n!
     */
    public static List<List<Integer>> permute(int[] nums) {
        // list to track all the permutations
        List<List<Integer>> result = new ArrayList<>();
        // list to track visited elements for each recursive call
        List<Integer> current = new ArrayList();
        backtrack(result, current, nums);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            // we need to check if the element is already visited as to avoid any duplicates
            if (!current.contains(num)) {
                current.add(num);
                backtrack(result, current, nums);
                // remove the recently added element to help traverse into another path
                current.remove(current.size() - 1);
            }
        }
    }
}
