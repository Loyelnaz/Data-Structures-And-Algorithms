package algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode - https://leetcode.com/problems/subsets/description/
 *
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 */
public class SubsetOfArrayElements {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(Arrays.asList(subsets(nums)));
    }

    /**
     * Time complexity - O(n.2^n)
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        // to avoid duplicates, we would pass an index
        subsets(nums, 0, current, result);
        return result;
    }

    public static void subsets(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        if (index > nums.length) {
            return;
        }

        result.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            subsets(nums, i+1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
