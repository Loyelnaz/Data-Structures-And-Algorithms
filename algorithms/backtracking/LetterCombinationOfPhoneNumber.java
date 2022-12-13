package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LetterCombinationOfPhoneNumber {

    private static final String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        String strs = "23";
        System.out.println(letterCombinations(strs));
    }

    //TODO add explanation
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        StringBuilder current = new StringBuilder("");

        letterCombinations(digits, 0, result, current);
        return result;
    }

    private static void letterCombinations(String digits, int index, List<String> result, StringBuilder current) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        String keypadValue = keypad[digit];

        for (int i = 0; i < keypadValue.length(); i++) {
            current.append(keypadValue.charAt(i));
            letterCombinations(digits, index+1, result, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
