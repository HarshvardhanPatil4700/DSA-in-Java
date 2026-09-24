// You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
// Two intervals are considered overlapping if they share at least one point.
// Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
// Return intervals after the insertion.
// Note that you don't need to modify intervals in-place. You can make a new array and return it.

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        boolean inserted = false;
        for(int i = 0; i < intervals.length; i++) {
            // if new interval comes before current interval 
            if(!inserted && newInterval[1] < intervals[i][0]) {
                res.add(newInterval);
                inserted = true;
            }

            // if current interval is completely before the new interval (non overlapping)
            if(intervals[i][1] < newInterval[0]) {
                res.add(intervals[i]);
            }

            // if new interval overlapps (merges) with the current interval
            else if(intervals[i][0] <= newInterval[1]) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
            // Add the remaining intervals
            else {
                res.add(intervals[i]);
            }
        }

        // edge case :
        if(!inserted) {
            res.add(newInterval);
        }

        return res.toArray(new int[res.size()][]);
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4, 8};
        int[][] result = insert(intervals, newInterval);
        for (int[] interval : result) {
            System.out.print(
                "[" + interval[0] + ", " + interval[1] + "]"
            );
        }
        System.out.println();

        int[][] intervals1 = {{1,2},{3,5},{6,7},{8,10},{12,14}};
        int[] newInterval1 = {15, 18};// the new interval is not overlapping neither it is within range so it is added at end
        int[][] result1 = insert(intervals1, newInterval1);
        for (int[] interval : result1) {
            System.out.print(
                "[" + interval[0] + ", " + interval[1] + "]"
            );
        }
    }
}
