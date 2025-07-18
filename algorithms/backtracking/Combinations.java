package algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two integers n and k, return all combinations of k numbers out of the range [1, n] in any order.
 *
 * For example, given n = 4, k = 2, return [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
 *
 * https://leetcode.com/problems/combinations/description/
 */
public class Combinations {

    public static void main(String[] args) {
        System.out.println(Arrays.asList(combine(4, 2)));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int n, int k, int index, List<Integer> curr, List<List<Integer>> result) {
        if (curr.size() == k) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i <= n; i++) {
            curr.add(i);
            backtrack(n, k, i + 1, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}
