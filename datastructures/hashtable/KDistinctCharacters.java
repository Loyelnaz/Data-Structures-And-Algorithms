package datastructures.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a string s and an integer k. Find the length of the longest substring that contains at most k distinct characters.
 *
 * For example, given s = "eceba" and k = 2, return 3. The longest substring with at most 2 distinct characters is "ece".
 */
public class KDistinctCharacters {

    public static void main(String[] args) {
        String str = "eaeba";
        int k = 2;
        int result = distinctCharacters(str, k);
        System.out.println(result);
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(k)
     */
    private static int distinctCharacters(String str, int k) {
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;
        int length = 0;

        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);

            while (charMap.size() > k) {
                char remove = str.charAt(left);
                int value = charMap.get(remove) - 1;
                charMap.getOrDefault(remove, value);

                if (value == 0) {
                    charMap.remove(remove);
                }
                left++;
            }

            int subStringLength = right - left + 1;
            length = Math.max(length, subStringLength);
        }
        return length;
    }
}
