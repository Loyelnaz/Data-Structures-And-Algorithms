package datastructures.heaps;

import java.util.Arrays;

public class Heap {
    public static void main(String[] args) {
        int[] arr = {1,4,7,12,15,14,9};
        System.out.println("Before heapify: "+ Arrays.toString(arr));
        buildMaxHeap(arr);
        System.out.println("After heapify: "+ Arrays.toString(arr));
    }

    // O(nlogn) - heapify function is called O(n) times
    public static void buildMaxHeap(int[] arr) {
        int arrSize = arr.length;
        // start from the last parent node
        for (int i = (arrSize - 1) / 2; i >= 0; i--) {
            maxHeapify(arr, i);
        }
    }

    // O(logn) - we start from the rightmost leaf node,
    // and then move up to the root node
    public static void maxHeapify(int[] arr, int index) {
        int heapSize = arr.length;
        int largest = index;

        // this check is to consider only the parent nodes
        while (largest < heapSize / 2) {
            int left = (2 * index) + 1;
            int right = (2 * index) + 2;

            if (left < heapSize && arr[left] > arr[index]) {
                largest = left;
            }
            if (right < heapSize && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest != index) {
                // swap parent with largest child node
                int temp = arr[index];
                arr[index] = arr[largest];
                arr[largest] = temp;
                // after the swap, set the index to the largest
                // so that we check the heap property for the swapped node
                index = largest;
            } else {
                break;
            }
        }
    }
}
