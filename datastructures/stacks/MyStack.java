package datastructures.stacks;

public interface MyStack<T> {
    void push(T data);
    T pop();
    T peek();
    boolean empty();
}
