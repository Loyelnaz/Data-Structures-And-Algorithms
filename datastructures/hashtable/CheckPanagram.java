package datastructures.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * A pangram is a sentence where every letter of the English alphabet appears at least once.
 * Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
 *
 * Leetcode- https://leetcode.com/problems/check-if-the-sentence-is-pangram/
 */
public class CheckPanagram {
    public static void main(String[] args) {
        String input = "thequickbrownfoxjumpsoverthelazydog";

        System.out.println(isPanagram(input));
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1) OR O(m) where m=26
     */
    public static boolean isPanagram(String sentence) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < sentence.length(); i++) {
            set.add(sentence.charAt(i));
        }

        return set.size() == 26;
    }
}
