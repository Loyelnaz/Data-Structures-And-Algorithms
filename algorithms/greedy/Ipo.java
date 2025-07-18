package algorithms.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/ipo/description/
 */
public class Ipo {

    public static void main(String[] args) {
        int[] profits = {1,2,3};
        int[] capital = {0,1,1};

        System.out.println(findMaximizedCapital(2, 0, profits, capital));
    }

    /**
     * Time Complexity - O((k + n) * logn)
     * Space Complexity - O(n)
     */
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i] = new int[]{capital[i], profits[i]};
        }

        // sort based on the capital
        Arrays.sort(projects, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        int i = 0;

        // O(k + n) -> we do (k + n) operations below
        for (int j = 0; j < k; j++) {
            // add to the heap only if the project capital is within the capital at hand
            while (i < n && projects[i][0] <= w) {
                heap.add(projects[i][1]);
                i++;
            }

            // this means no possible projects to pick that fall within the capital at hand
            if (heap.isEmpty()) {
                return w;
            }

            w += heap.remove();
        }

        return w;
    }
}
