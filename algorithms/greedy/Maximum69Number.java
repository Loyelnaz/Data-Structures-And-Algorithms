package algorithms.greedy;

/**
 * https://leetcode.com/problems/maximum-69-number/description/
 */
public class Maximum69Number {
    public static void main(String[] args) {
        int num = 9669;

        System.out.println(maximum69Number(num));
    }

    /**
     * The problem can be solved with StringBuilder or String too, but efficient approach would be to use Greedy approach
     *
     * Time Complexity - O(L), where L is the number of digits
     * Space Complexity - O(1)
     */
    public static int maximum69Number (int num) {
        int firstIndexOfSix = -1;
        int digitCount = 0;
        int temp = num;

        while (temp > 0) {
            // If the current digit is '6', record it as the highest digit of 6.
            if (temp % 10 == 6) {
                firstIndexOfSix = digitCount;
            }
            digitCount++;
            temp = temp / 10;
        }

        // If we don't find any digit of '6', return the original number,
        // otherwise, increment 'num' by the difference made by the first '6'.
        if (firstIndexOfSix != -1) {
            num = num += (3 * Math.pow(10, firstIndexOfSix));
        }

        return num;
    }
}
