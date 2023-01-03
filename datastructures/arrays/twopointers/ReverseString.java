package datastructures.arrays.twopointers;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};

        reverseString(s);
        System.out.println(s);
    }

    /**
     * To reverse a string in order, we can use two pointer approach
     *
     * Time Complexity - O(n) to swap n/2 elements
     * Space Complexity - O(1)
     */
    public static void reverseString(char[] s) {
        int start = 0, end = s.length - 1;

        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }
    }
}
