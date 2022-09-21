package algorithms.sorting;

public class BubbleSort {
    public static void main(String[] args) {
        // More test cases to try out
//        int[] arr = {3, 7, 11, 13, 19, 27};
//        int[] arr = {3, 7, 11, 13, 19, 20};
        int[] arr = {10, 1, 7, 9, 14, 2};

        bubbleSort(arr);
        printArray(arr);
    }

    // Complexity would O(n^2) and space compl. is O(1)
    // Best case - array is already sorted - O(n). Worst case - array is reverse sorted - O(n^2)
    // In each ith rounds/iterations, the ith largest element in the array would be placed in its right position
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        //for round 1 to n-1
        for (int i = 0; i < n-1; i++) {
            boolean swapped = false;
            // process element till n-i th index
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                //already sorted
                break;
            }
        }
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
