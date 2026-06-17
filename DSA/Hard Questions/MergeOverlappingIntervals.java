// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {
    public static List<List<Integer>> mergeOverlapInterval(int [][]arr) {
        // 1. Brute force :
        // Sort 2D array rows based on the first element of each row in ascending order
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        int i =0;

        while(i < n) {
            int start = arr[i][0];
            int end = arr[i][1]; // Eg: [2,5] so here start = 2 and end = 5

            int j = i+1;
            while(j < n && arr[j][0] <= end) {
                end = Math.max(end, arr[j][1]);
                j++;
            }
             
            ans.add(Arrays.asList(start, end));            
            i = j; // Move to next non-overlapping interval
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        List<List<Integer>> result = mergeOverlapInterval(intervals);
        for (List<Integer> interval : result) {
            System.out.print(interval + " ");
        }
    }
}