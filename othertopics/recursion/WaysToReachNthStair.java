package othertopics.recursion;

/**
    Problem - https://www.codingninjas.com/codestudio/problems/count-ways-to-reach-nth-stairs_798650
 */
public class WaysToReachNthStair {
    public static void main(String[] args) {
        System.out.println(countDistinctWayToClimbStair(5));
    }

    public static int countDistinctWayToClimbStair(long nStairs) {
        if (nStairs < 0) {
            return 0;
        }

        if (nStairs == 0) {
            return 1;
        }
        // as there are only two ways of getting to the nth stair
        // (i.e. by taking 1 step OR by taking 2 steps),
        // we can use a recursive function call that would be for (n-1) and (n-2)
        return countDistinctWayToClimbStair(nStairs-1) + countDistinctWayToClimbStair(nStairs-2);
    }
}
