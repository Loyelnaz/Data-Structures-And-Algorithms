package algorithms.greedy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/description/
 */
public class MaxBagsWithFullCapacity {
    public static void main(String[] args) {
        int[] capacity = {2,3,4,5};
        int[] rocks = {1,2,4,4};
        int additionalRocks = 2;

        System.out.println(maximumBags(capacity, rocks, additionalRocks));
    }

    /**
     * Time Complexity - O(nlogn)
     * Space Complexity - O(n)
     */
    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] spaceLeft = new int[capacity.length];

        // Find the remaining capacity that's required to get the full capacity
        for (int i = 0; i < capacity.length; i++) {
            spaceLeft[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(spaceLeft);
        int fullCapacity = 0;

        for (int space : spaceLeft) {
            // If there are no additional rocks left to occupy the full capacity of rocks, we stop the iteration.
            // Otherwise, keep filling the rocks.
            if (additionalRocks < space) {
                return fullCapacity;
            }

            additionalRocks -= space;
            fullCapacity++;
        }

        return fullCapacity;
    }
}
