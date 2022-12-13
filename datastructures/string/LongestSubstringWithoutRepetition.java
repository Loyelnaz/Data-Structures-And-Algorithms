package datastructures.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepetition {
    public static void main(String[] args) {
        String strs = "pwwkew";
        System.out.println(lengthOfLongestSubstring(strs));
    }

    //TODO Add explanation
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int result = 0;
        int left = 0, right = 0;

        while (right < len) {
            char rightChar = s.charAt(right);

            if (map.containsKey(rightChar)) {
                left = Math.max(left, map.get(rightChar));
            }

            result = Math.max(result, right - left + 1);
            map.put(rightChar, right + 1);
            right++;
        }

        return result;
    }
}
