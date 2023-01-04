package datastructures.arraysandstrings.twopointers;

/**
 * Return true if a given string is a palindrome, false otherwise.
 *
 * A string is a palindrome if it reads the same forwards as backwards.
 * That means, after reversing it, it is still the same string.
 *
 * For example: "abcdcba", or "racecar".
 */
public class CheckPalidrome {
    public static void main(String[] args) {
        String str = "racecar";
        System.out.println(checkIfPalindrome(str));
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public static boolean checkIfPalindrome(String s) {
        int start = 0, end = s.length() - 1;

        while (start < end) {
            // check if the two characters are not equal
            // if it's a valid palindrome, 0th & (n-1)th,
            // 1st & (n-2)th and so on characters are equal
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
