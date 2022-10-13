package algorithms.greedy;

import java.util.Arrays;

public class BoatsToSavePeople {
    public static void main(String[] args) {
        int[] people = {3,5,4,3};
        int limit = 5;

        System.out.println(numRescueBoats(people, limit));
    }

    /**
     * If the heaviest person can share a boat with the lightest person, then do so.
     * Otherwise, the heaviest person can't pair with anyone, so they get their own boat.
     *
     * The lightest person can pair with anyone, they might as well pair with the heaviest person.
     */
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int lightest = 0, heaviest = people.length - 1;
        int numberOfBoats = 0;

        while (lightest <= heaviest) {
            if (people[lightest] + people[heaviest] <= limit) {
                lightest++;
            }

            heaviest--;
            numberOfBoats++;
        }

        return numberOfBoats;
    }
}
