package algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/description/
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        System.out.println(combinationSum(candidates, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, 0, ans, candidates, target);
        return ans;
    }

    public static void backtrack(List<Integer> path, int start, int curr, List<List<Integer>> ans, int[] candidates, int target) {
        if (curr == target) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            if (curr + num <= target) {
                path.add(num);
                backtrack(path, i, curr + num, ans, candidates, target);
                path.remove(path.size() - 1);
            }
        }

    }
}
