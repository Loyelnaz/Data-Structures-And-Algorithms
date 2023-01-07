package datastructures.arraysandstrings.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals, and return an array of the
 * non-overlapping intervals that cover all the intervals in the input.
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    /**
     * Time complexity : O(nlogn)
     * Space complexity : O(logN)
     */
    public static int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();

        if (intervals.length == 0 || intervals == null) {
            return result.toArray(new int[0][]);
        }

        // sort the array based on the start interval
        // sorting takes about O(nlogn) time, and O(logn) space
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] interval : intervals) {
            // if there's an overlap, we find the max between the two end intervals
            if (interval[0] <= end) {
                end = Math.max(end, interval[1]);
            } else {
                // if there's no overlap, we add the current start and end intervals,
                // and track the next intervals
                result.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }

        result.add(new int[]{start, end});
        return result.toArray(new int[0][]);
    }
}
