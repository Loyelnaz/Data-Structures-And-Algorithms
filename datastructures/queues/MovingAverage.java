package datastructures.queues;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

    int size;
    Queue<Integer> queue;

    public MovingAverage(int size) {
        this.size = size;
        queue = new LinkedList<>();
    }

    public double next(int val) {
        if (queue.size() >= size) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            queue.offer(val);
            return val;
        }

        queue.offer(val + queue.peek());
        return queue.peek() / queue.size();
    }

}
