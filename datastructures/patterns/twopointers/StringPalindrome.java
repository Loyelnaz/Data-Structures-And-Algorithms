package datastructures.patterns.twopointers;

/**
 * Return true if a given string is a palindrome, false otherwise.
 *
 * A string is a palindrome if it reads the same forwards as backwards.
 * That means, after reversing it, it is still the same string.
 * For example: "abcdcba", or "racecar".
 */
public class StringPalindrome {
    public static void main(String[] args) {
        String input = "abcba";
        System.out.println(isPalindrome(input));
    }

    /**
     * If a string is the same after being reversed, that means the first character is the same as the last character,
     * and the second character is the same as the second last character, and so on.
     * We can use the two pointers technique here to check that all corresponding (i and (n-i-1)) characters are equal.
     *
     * @param str
     * @return
     */
    private static boolean isPalindrome(String str) {
        int start = 0, end = str.length()-1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
