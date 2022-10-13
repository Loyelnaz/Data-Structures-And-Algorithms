package datastructures.stacks;

import java.util.EmptyStackException;

public class StackImpl<T> implements MyStack<T> {
    private static class Stack<T> {
        private T data;
        private Stack<T> next;

        public Stack(T data) {
            this.data = data;
        }
    }

    private Stack<T> top;

    @Override
    public void push(T data) {
        Stack<T> stack = new Stack(data);
        stack.next = top;
        top = stack;
    }

    @Override
    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    @Override
    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    @Override
    public boolean empty() {
        return top == null;
    }
}
