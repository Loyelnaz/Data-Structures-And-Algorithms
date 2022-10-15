package datastructures.stacks;

public class StackImplUsingArray<T> {
    private int top;
    private int maxArraySize;
    private T[] arr;

    /*
    Java does not allow generic type arrays. So we have used an
    array of Object type and type-casted it to the generic type V.
    This type-casting is unsafe and produces a warning.
    Comment out the line below and execute again to see the warning.
    */
    @SuppressWarnings("unchecked")
    StackImplUsingArray(int capacity) {
        this.top = -1;
        maxArraySize = capacity;
//        arr = (T[]) Array.newInstance(stackClass, capacity);
        arr = (T[])new Object[capacity];
    }

    // Adds the element to the top of the stack
    public void push(T data) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = data;
    }

    // Removes an element from the top of the stack and returns the value
    public T pop() {
        if (empty()) {
            System.out.println("Stack Underflow");
            return null;
        }
        return arr[top--];
    }

    // Returns the value of top element in the stack
    public T top() {
        if (empty()) {
            return null;
        }
        return arr[top];
    }

    public boolean empty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxArraySize - 1;
    }

    public static void main(String[] args) {
        StackImplUsingArray stack = new StackImplUsingArray(5);
        System.out.println("IsEmpty - " + stack.empty());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        System.out.println("Top - " + stack.top());
        System.out.println("Pop - " + stack.pop());
        System.out.println("Top - " + stack.top());
        System.out.println("IsEmpty - " + stack.empty());
        stack.push(60);
        System.out.println("Top - " + stack.top());
    }
}
