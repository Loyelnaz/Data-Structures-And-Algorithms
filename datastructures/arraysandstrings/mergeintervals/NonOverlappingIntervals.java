package datastructures.arraysandstrings.mergeintervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/non-overlapping-intervals/description/
 *
 * Given an array of intervals where intervals[i] = [starti, endi],
 * return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 *
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
 *
 * Input: intervals = [[1,100],[11,22],[1,11],[2,12]]
 * Output: 2
 */
public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};

        System.out.println(eraseOverlapIntervals(intervals));
    }

    /**
     * Time complexity : O(nlogn), for sorting the array
     * Space complexity : O(logN), space required while sorting the array
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        // sort the array based on the end interval
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int previous = 0, removeIntervals = 0;
        for(int current = 1; current < intervals.length; current++) {
            // remove the interval only when start of current interval
            // falls within previous interval range
            if (intervals[current][0] < intervals[previous][1]) {
                removeIntervals++;
            } else {
                previous = current;
            }
        }

        return removeIntervals;
    }
}
