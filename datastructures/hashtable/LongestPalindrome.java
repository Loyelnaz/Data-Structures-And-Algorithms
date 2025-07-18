package datastructures.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-palindrome/description/
 *
 * Given a string s which consists of lowercase or uppercase letters,
 * return the length of the longest palindrome that can be built with those letters.
 *
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 *
 * Input: s = "abccccdd"
 * Output: 7
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }

    /**
     * To make a string a palindrome, we would either need all the characters of even occurrences,
     * OR one odd and rest even occurrences.
     *
     * The set would keep track of all the characters occurring odd number of times.
     * We can form a longest palindrome by just deducting the size of the set from the original string.
     *
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    public static int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();

        for (Character ch : s.toCharArray()) {
            if (set.contains(ch)) {
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }

        return set.size() != 0 ? s.length() - set.size() + 1 : s.length();
    }
}
