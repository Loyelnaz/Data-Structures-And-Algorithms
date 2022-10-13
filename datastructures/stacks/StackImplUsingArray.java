//package datastructures.stacks;
//
//public class StackImplUsingArray implements MyStack {
//    private int peek;
//    private int[] arr;
//    private int arrSize;
//
//    StackImplUsingArray(int capacity) {
//        peek = -1;
////        arr = (T[]) Array.newInstance(stackClass, capacity);
//        arr = new int[capacity];
//    }
//
//    @Override
//    public void push(int data) {
//        if (peek == arr.length-1) {
//            System.out.println("Stack Overflow");
//            return;
//        }
//        arr[++peek] = data;
//    }
//
//    @Override
//    public int pop() {
//        if (peek == -1) {
//            System.out.println("Stack Underflow");
//        }
//        return arr[peek--];
//    }
//
//    @Override
//    public int peek() {
//        if (peek != -1) {
//            return arr[peek];
//        }
//        return -1;
//    }
//
//    @Override
//    public boolean empty() {
//        if (peek == -1) {
//            return true;
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        StackImplUsingArray stack = new StackImplUsingArray(5);
//        System.out.println("IsEmpty - " + stack.empty());
//        stack.push(10);
//        stack.push(20);
//        stack.push(30);
//        stack.push(40);
//        stack.push(50);
//        stack.push(60);
//        System.out.println("Peek - " + stack.peek());
//        System.out.println("Pop - " + stack.pop());
//        System.out.println("Peek - " + stack.peek());
//        System.out.println("IsEmpty - " + stack.empty());
//    }
//}
