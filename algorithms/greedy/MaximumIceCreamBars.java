package algorithms.greedy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-ice-cream-bars/description/
 */
public class MaximumIceCreamBars {
    public static void main(String[] args) {
        int[] costs = {1,3,2,4,1};
        int coins = 7;

        System.out.println(maxIceCream(costs, coins));
    }

    /**
     * Time Complexity - O(nlogn)
     * Space Complexity - O(1)
     */
    public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int totalBars = 0;
        int currentCoins = coins;

        for (int cost : costs) {
            if (cost > currentCoins) {
                return totalBars;
            }
            currentCoins -= cost;
            totalBars++;
        }

        return totalBars;
    }
}
