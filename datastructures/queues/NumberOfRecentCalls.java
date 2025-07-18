package datastructures.queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the RecentCounter class. It should support ping(int t), which records a call at time t,
 * and then returns an integer representing the number of calls that have happened in the range [t - 3000, t].
 * Calls to ping will have increasing t.
 *
 * https://leetcode.com/problems/number-of-recent-calls/description/
 */
public class NumberOfRecentCalls {
    class RecentCounter {
        Queue<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            // Remove all the calls beyond the range of [t-3000, t]
            while (!queue.isEmpty() && queue.peek() < t - 3000) {
                queue.poll();
            }

            queue.offer(t);
            return queue.size();
        }
    }
}
