package othertopics.recursion;

/**
 * Problem - check if the elements in an array are sorted using recursion
 */
public class ArraySorted {
    public static void main(String[] args) {
        int[] arr = {2,4,6,9,1,15};
        System.out.println(isArraySorted(arr, 0));
    }

    private static boolean isArraySorted(int[] arr, int i) {
        // whenever the index reaches the end of the array, we assume it's sorted
        if (i == arr.length - 1) {
            return true;
        }

        boolean recursiveResult = isArraySorted(arr, i+1);
        // we check if the current element is less than the next element.
        // Meaning, once we reach the end of the array,
        // we compare (end-1) with the end element
        return recursiveResult & arr[i] <= arr[i+1] ;
    }
}
