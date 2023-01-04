package datastructures.arraysandstrings.slidingwindow;

/**
 * You are given a binary substring s (a string containing only "0" and "1").
 * An operation involves flipping a "0" into a "1".
 * What is the length of the longest substring containing only "1" after performing at most one operation?
 *
 * For example, given s = "1101100111", the answer is 5.
 * If you perform the operation at index 2, the string becomes 1111100111
 */
public class LongestSubstringAfterAtMostOneOperation {
    public static void main(String[] args) {
        String str = "1101100111";
        System.out.println(lengthOfLongestSubstring(str));
    }

    /**
     * As the string can only contain '1' and '0', we can look at this problem
     * as "what is the longest substring that contains at most one '0'?".
     * This makes it easy for us to solve with a sliding window
     * where our condition is window.count("0") <= 1.
     *
     * We can use an integer "zeroCount" that keeps track of how many '0' we currently have in our window.
     *
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    private static int lengthOfLongestSubstring(String str) {
        int length = 0;
        int left = 0, zeroCount = 0;

        for (int right = 0; right < str.length(); right++) {
            if (str.charAt(right) == '0') {
                zeroCount++;
            }

            // if the total zeroes are more than 1, we move the left index
            // to a point where we will have only one '0'
            while (zeroCount > 1) {
                if (str.charAt(left) == '0') {
                    zeroCount--;
                }

                left++;
            }

            length = Math.max(length, right - left + 1);
        }

        return length;
    }
}
