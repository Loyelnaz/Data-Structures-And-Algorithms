package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 *
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 *
 * Return a list of all possible valid combinations. The list must not contain the same combination twice,
 * and the combinations may be returned in any order.
 *
 * https://leetcode.com/problems/combination-sum-iii/description/
 */
public class CombinationSumThree {

    public static void main(String[] args) {
        List<List<Integer>> result = combinationSum3(3, 9);
        System.out.println(result);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k, 1, n, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int k, int index, int remain, List<Integer> curr, List<List<Integer>> result) {
        // instead of passing the 'n' value and calculating the list sum every time pass a 'remain' attribute
        if (curr.size() == k && remain == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < 10; i++) {
            if (!curr.contains(i)) {
                curr.add(i);
                backtrack(k, i + 1, remain - i, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }

}
