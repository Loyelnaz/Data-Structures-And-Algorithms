package datastructures.stacks;

/**
 * Implement two stacks using a single array, and having push1(), pop1(), push2(), and pop2() operations
 */
public class TwoStacksUsingAnArray<T> {
    private T[] arr;
    private int arraySize;
    private int top1, top2;

    /**
     * If we divide an array into two halves, there's a good chance that
     * we could have few indices of either stack1 or stack2 under-utilized
     *
     * Better Approach - take a single array, start stack1 from 0th index, and stack2 from the last index.
     */
    @SuppressWarnings("unchecked")
    public TwoStacksUsingAnArray(int capacity) {
        this.arraySize = capacity;
        this.top1 = -1;
        this.top2 = arraySize;
        arr = (T[]) new Object[capacity];
    }

    public void push1(T data) {
        if (top1 < top2 - 1) {
            arr[++top1] = data;
        }
    }

    public void push2(T data) {
        if (top1 < top2 - 1) {
            arr[--top2] = data;
        }
    }

    public T pop1() {
        if (top1 > -1) {
            return arr[top1--];
        }
        return null;
    }

    public T pop2() {
        if (top2 != arraySize) {
            return arr[top2++];
        }
        return null;
    }
}
