package algorithms.sorting;

public class QuickSort {
    public static void main(String[] args) {
        // More test cases to try out
//        int[] arr = {3, 7, 11, 13, 19, 27};
//        int[] arr = {3, 7, 11, 13, 19, 20};
        int[] arr = {10, 1, 7, 9, 14, 2};

        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    // 1. take an element and put it in a place such that elements in the left side would be less than this element
    // and right side will have elements greater
    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int partitionIndex = partition(arr, left, right);

        quickSort(arr, left, partitionIndex - 1);

        quickSort(arr, partitionIndex + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivotElement = arr[left];

        int count = 0;
        for (int i = left + 1; i < right; i++) {
            if (arr[i] <= pivotElement) {
                count++;
            }
        }

        int pivotIndex = left + count;
        swap(arr, left, pivotIndex);

        int start = left, end = right;
        while (start < pivotIndex && right > pivotIndex) {
            while (arr[start] < arr[pivotIndex]) {
                start++;
            }

            while (arr[end] > arr[pivotIndex]) {
                end--;
            }

            if (start < pivotIndex && right > pivotIndex) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }

        return pivotIndex;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
