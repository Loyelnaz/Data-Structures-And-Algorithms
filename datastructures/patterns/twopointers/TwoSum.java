package datastructures.patterns.twopointers;

/**
 * Given a sorted array of unique integers and a target integer,
 * return true if there exists a pair of numbers that sum to target, false otherwise.
 *
 * For example, given nums = [1, 2, 4, 6, 8, 9, 14, 15] and target = 13, return true because 4 + 9 = 13.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] input = {1,2,4,6,8,9,14,15};
        int target = 21;
        System.out.println(twoSum(input, target));
    }

    /**
     * The brute force solution would be to iterate over all pairs of integers.
     * This would result in a time complexity of O(n^2), where 'n' is the length of the array.
     *
     * Because the array is sorted, we can use two pointers to improve to an O(n) time complexity.
     */
    private static boolean twoSum(int[] arr, int target) {
        int start = 0, end = arr.length-1;

        while (start < end) {
            if (arr[start] + arr[end] == target) {
                return true;
            } else if (arr[start] + arr[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }
}
