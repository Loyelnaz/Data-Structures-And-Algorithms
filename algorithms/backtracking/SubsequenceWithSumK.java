package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Subsequence with sum K
 *
 * Input: {1,2,1}, sum = 2
 * Output: {1,1} and {2}
 */
public class SubsequenceWithSumK {
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        int target = 2;

        System.out.println(subsequenceWithSumK(nums, target));
    }

    // Time - O(2^n)
    public static List<List<Integer>> subsequenceWithSumK(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(0, nums, current, result, 0, target);

        return result;
    }

    private static void backtrack(int index, int[] nums, List<Integer> current,
                                  List<List<Integer>> result, int sum, int target) {
        // possible if array contains only positive integers
        if (sum > target) {
            return;
        }
        if (index >= nums.length) {
            if (sum == target) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        current.add(nums[index]);
        sum += nums[index];
        backtrack(index + 1, nums, current, result, sum, target);

        current.remove(current.size() - 1);
        sum -= nums[index];
        backtrack(index + 1, nums, current, result, sum, target);
    }
}
