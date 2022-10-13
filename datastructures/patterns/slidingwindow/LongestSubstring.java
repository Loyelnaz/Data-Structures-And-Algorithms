package datastructures.patterns.slidingwindow;

/**
 * You are given a binary substring s (a string containing only "0" and "1").
 * An operation involves flipping a "0" into a "1".
 * What is the length of the longest substring containing only "1" after performing at most one operation?
 *
 * For example, given s = "1101100111", the answer is 5.
 * If you perform the operation at index 2, the string becomes 1111100111.
 */
public class LongestSubstring {
    public static void main(String[] args) {
        String str = "1101100111";

        System.out.print(longestSubstring(str));
    }

    /**
     * Because the string can only contain "1" and "0", another way to look at this problem is "what is the longest substring that contains at most one "0"?".
     * This makes it easy for us to solve with a sliding window where our condition is window.count("0") <= 1.
     * Again, we can use an integer curr that keeps track of how many "0" we currently have in our window.
     */
    public static int longestSubstring(String str) {
        int left = 0, zeroCount = 0;
        int maxLength = 0;

        for (int right = 0; right < str.length(); right++) {
            if (str.charAt(right) == '0') {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (str.charAt(left) == '0') {
                    zeroCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right-left+1);
        }

        return maxLength;
    }
}
