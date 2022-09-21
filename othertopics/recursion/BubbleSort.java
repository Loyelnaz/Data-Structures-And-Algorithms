package othertopics.recursion;

public class BubbleSort {
    public static void main(String[] args) {
        // More test cases to try out
//        int[] arr = {3, 7, 11, 13, 19, 27};
//        int[] arr = {3, 7, 11, 13, 19, 20};
        int[] arr = {10, 1, 7, 9, 14, 3};

        bubbleSort(arr, arr.length);
        printArray(arr);
    }

    // Complexity would O(n^2) and space compl. is O(1)
    // Best case - array is already sorted - O(n). Worst case - array is reverse sorted - O(n^2)
    // In each ith rounds/iterations, the ith largest element in the array would be placed in its right position
    private static void bubbleSort(int[] arr, int n) {
        if (n == 0 || n == 1) {
            return;
        }
        //solve the first case i.e. move the largest element to the right position by swapping
        for (int i = 0; i < n-1; i++) {
            if (arr[i] > arr[i+1]) {
                // swap arr[j+1] and arr[j]
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        bubbleSort(arr, n-1);
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
