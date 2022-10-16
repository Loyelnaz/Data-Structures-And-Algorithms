package datastructures.queues;

import java.util.Stack;

/**
 * Implement a Queue using Stack
 */
public class QueueImplUsingStack<T> {
    Stack<T> stack1;
    Stack<T> stack2;

    // We would be using two stacks to implement a queue since we need to follow FIFO ordering
    public QueueImplUsingStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Time - O(1)
    public void enqueue(T data) {
        stack1.push(data);
    }

    // Time - O(1), even though it might seem we would need O(n) time,
    // but occurrence of this worst case is infrequent, hence amortized its cost
    public T dequeue() {
        if (isEmpty()) {
            return null;
        } else if (stack2.isEmpty()) {
            //if stack2 is empty, we pop all the elements
            //from stack1 and push them to the stack2
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            // return the top of stack2
            return stack2.pop();
        } else {
            return stack2.pop();
        }

    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public T top() {
        if (isEmpty()) {
            return null;
        } else if (!stack2.isEmpty()) {
            return stack2.peek();
        } else {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            // return the top of stack2
            return stack2.peek();
        }
    }

    public static void main(String[] args) {
        QueueImplUsingStack queue = new QueueImplUsingStack<>();
        System.out.println("IsEmpty - " + queue.isEmpty());
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        System.out.println("Pop - " + queue.dequeue());
        System.out.println("Top - " + queue.top());
        queue.enqueue(50);
        System.out.println("Pop - " + queue.dequeue());
        System.out.println("Pop - " + queue.dequeue());
        System.out.println("Top - " + queue.top());
    }
}
