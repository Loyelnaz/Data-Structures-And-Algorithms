package datastructures.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array.
 * When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach any index with value 0.
 *
 * Notice that you can not jump outside of the array at any time.
 *
 * https://leetcode.com/problems/jump-game-iii/description/
 */
public class JumpGameThree {

    public static void main(String[] args) {
        int[] arr = {4,2,3,0,3,1,2};
        System.out.print(canReach(arr, 5));
    }

    /**
     * Time Complexity - O(n), since we will visit every index at most once
     * Space Complexity - O(n)
     */
    public static boolean canReach(int[] arr, int start) {
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        seen.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int i = queue.remove();

            if (arr[i] == 0) {
                return true;
            }

            int higherIndex = i + arr[i];
            int lowerIndex = i - arr[i];

            if (higherIndex < arr.length && !seen.contains(higherIndex)) {
                seen.add(higherIndex);
                queue.add(higherIndex);
            }

            if (lowerIndex >= 0 && !seen.contains(lowerIndex)) {
                seen.add(lowerIndex);
                queue.add(lowerIndex);
            }
        }

        return false;
    }

}
