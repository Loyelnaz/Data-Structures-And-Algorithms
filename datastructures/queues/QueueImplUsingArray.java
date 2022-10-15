package datastructures.queues;

public class QueueImplUsingArray<T> {
    // we will be using the concept of circular array to better utilize the space
    T[] arr;
    int front;
    int rear;
    int currentArraySize;
    int maxArraySize;

    @SuppressWarnings("unchecked")
    public QueueImplUsingArray(int capacity) {
        maxArraySize = capacity;
        currentArraySize = 0;
        front = 0;
        rear = -1;
        arr = (T[]) new Object[capacity];
    }

    public void enqueue(T data) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        rear = (rear + 1) % maxArraySize;
        arr[rear] = data;
        currentArraySize++;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        T temp = arr[front];
        front = (front + 1) % maxArraySize;
        currentArraySize--;
        return temp;
    }

    public T top() {
        if (isEmpty()) {
            return null;
        }
        return arr[front];
    }

    public void printQueue() {
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public boolean isEmpty() {
        return currentArraySize == 0;
    }

    public boolean isFull() {
        return currentArraySize == maxArraySize;
    }

    public static void main(String[] args) {
        QueueImplUsingArray queue = new QueueImplUsingArray(5);
        System.out.println("IsEmpty - " + queue.isEmpty());
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        System.out.println("Peek - " + queue.top());
        System.out.println("Remove - " + queue.dequeue());
        System.out.println("Peek - " + queue.top());
        System.out.println("IsEmpty - " + queue.isEmpty());
        queue.printQueue();
        queue.enqueue(60);
        System.out.println("Peek - " + queue.top());
    }
}
