package datastructures.patterns.twopointers;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string
 * by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.
 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */
public class CheckSubsequence {
    public static void main(String[] args) {
        String t = "abcde";
        String s = "ace";

        System.out.println(isSubsequence(t, s));
    }

    /**
     * In this problem, we need to check if the characters of s appear in the same order in t, with gaps allowed.
     * For example, "ace" is a subsequence of "abcde" because "abcde" contains the letters "ace" in that same order.
     * The fact that they aren't consecutive doesn't matter.
     */
    private static boolean isSubsequence(String t, String s) {
        int index1 = 0, index2 = 0;

        while (index1 < t.length() && index2 < s.length()) {
            if (t.charAt(index1) == s.charAt(index2)) {
                index2++;
            }
            index1++;
        }
        return index2 == s.length();
    }
}
