package algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Subsequence - a contiguous or non-contiguous sequence that follows an order
 *
 * Input: arr[] = {3,1,2}
 * Output: {},{3},{1},{2},{3,1},{3,2},{1,2},{3,1,2}
 *
 * In total, for N elements, there could be 2^N subsequences
 */
public class PrintSubseqeunceOfArray {
    public static void main(String[] args) {
        int[] nums = {3,1,2};
        System.out.println(printSubsequence(nums));
    }

    /**
     * Time - O(2^n)
     * Space - O(n), depth of the recursion tree that we can have is 'n'
     */
    public static List<List<Integer>> printSubsequence(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(0, nums, current, result);

        return result;
    }

    // the sub-problem would be either to take the current element or not take
    private static void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // take the current element
        current.add(nums[index]);
        backtrack(index + 1, nums, current, result);
        // do not take the current element
        current.remove(current.size() - 1);
        backtrack(index + 1, nums, current, result);
    }

}
