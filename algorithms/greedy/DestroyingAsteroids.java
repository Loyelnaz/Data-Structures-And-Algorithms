package algorithms.greedy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/destroying-asteroids/description/
 */
public class DestroyingAsteroids {
    public static void main(String[] args) {
        int[] asteroids = {3,9,19,5,21};
        int mass = 10;

        System.out.println(asteroidsDestroyed(mass, asteroids));
    }

    /**
     * Since the mass of the planet keeps growing if it's greater than the mass of asteroid,
     * our optimal choice should be to pick minimum of asteroids
     *
     * Time Complexity - O(nlogn)
     * Space Complexity - O(1)
     */
    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        //O(nlogn) complexity of sorting asteroids
        Arrays.sort(asteroids);
        long currentMass = mass;

        // if m(planet) >= m(asteroid)
        // asteroid destroyed AND m(planet) += m(asteroid)
        // else planet destroyed
        for (int asteroid : asteroids) {
            if (asteroid > currentMass) {
                return false;
            }
            currentMass += asteroid;
        }

        return true;
    }
}
