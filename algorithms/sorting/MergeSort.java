package algorithms.sorting;

public class MergeSort {
    public static void main(String[] args) {
        // More test cases to try out
//        int[] arr = {3, 7, 11, 13, 19, 27};
//        int[] arr = {3, 7, 11, 13, 19, 20};
        int[] arr = {10, 1, 7, 9, 14, 2};

        mergeSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    // Time Complexity - O(n.logn)
    // Space Complexity - O(n)
    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = left + (right - left) / 2;

        // divide the left part of the array
        mergeSort(arr, left, middle);
        // divide the right part of the array
        mergeSort(arr, middle + 1, right);
        // merge both left and right part into a single array
        // this is easily done using 'merge two sorted array' logic
        merge(arr, left, middle, right);
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int length1 = middle - left + 1;
        int length2 = right - middle;

        int[] leftArray = new int[length1];
        int[] rightArray = new int[length2];

        // copy all the elements from the left part of the array
        for(int i = 0; i < length1; i++) {
            leftArray[i] = arr[left + i];
        }

        // copy all the elements from the right part of the array
        for(int i = 0; i < length2; i++) {
            rightArray[i] = arr[middle + 1 + i];
        }

        int index1 = 0, index2 = 0;
        int startIndex = left;
        while (index1 < length1 && index2 < length2) {
            if (leftArray[index1] < rightArray[index2]) {
                arr[startIndex++] = leftArray[index1++];
            } else {
                arr[startIndex++] = rightArray[index2++];
            }
        }

        // copy the remaining elements from both the arrays
        while (index1 < length1) {
            arr[startIndex++] = leftArray[index1++];
        }

        while (index2 < length2) {
            arr[startIndex++] = rightArray[index2++];
        }
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
