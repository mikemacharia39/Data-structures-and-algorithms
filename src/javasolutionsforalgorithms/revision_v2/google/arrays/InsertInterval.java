package javasolutionsforalgorithms.revision_v2.google.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/insert-interval/">...</a>
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi]
 * represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
 * You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals
 * still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * Return intervals after the insertion.
 *
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        //The time complexity of the given code is O(n),
        // where n is the number of intervals in the input array.
        List<int[]> result = new ArrayList<>();

        // Add intervals before newInterval that end before it starts
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                // Current interval ends before newInterval starts, add it to the result
                result.add(interval);
            } else if (interval[0] > newInterval[1]) {
                // Current interval starts after newInterval ends, add newInterval and update it
                result.add(newInterval);
                newInterval = interval;
            } else {
                // There is an overlap between the current interval and newInterval, merge them
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        result.add(newInterval); // Add the merged newInterval

        return result.toArray(new int[result.size()][2]);
    }

    /**
     * Time complexity: 0(n)
     * Space complexity O(n) because of the result array
     * Explanation: The idea is to iterate over the intervals and check if the current interval is before or after the
     * newInterval. If it is before, add it to the result array. If it is after, add the newInterval to the result array
     * and update the newInterval to the current interval. If there is an overlap, merge the intervals.
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert1(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];

        int[][] result = new int[intervals.length + 1][2];
        int resultIndex = 0;

        boolean newIntervalAdded = false;
        for (int[] interval : intervals) {
            if (interval[0] > end) {
                if (!newIntervalAdded) {
                    result[resultIndex++] = new int[]{start, end};
                    newIntervalAdded = true;
                }
                result[resultIndex++] = interval;
            } else if (interval[1] < start) {
                result[resultIndex++] = interval;
            } else {
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            }
        }

        if (!newIntervalAdded) {
            result[resultIndex++] = new int[]{start, end};
        }

        int[][] finalResult = new int[resultIndex][2];
        for (int i = 0; i < resultIndex; i++) {
            finalResult[i] = result[i];
        }

        return finalResult;
    }

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        int[][] intervals = new int[][]{{1, 3}, {6, 9}};
        int[] newInterval = new int[]{2, 5};
        int[][] result = insertInterval.insert(intervals, newInterval);

        System.out.println(Arrays.deepToString(result));
    }
}
