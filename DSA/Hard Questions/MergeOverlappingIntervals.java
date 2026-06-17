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

    public static int[][] merge(int[][] interval) {
        if(interval.length < 2) {
            return interval; // because the interval with length 1 or 0 cannot be merged
        }

        Arrays.sort(interval, (a,b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        int[] newInterval = interval[0];
        result.add(newInterval);

        for(int[] inter : interval) {
            if(inter[0] < newInterval[1]) {
                // Overlapping Intervals -> So, update the end if needed
                newInterval[1] = Math.max(newInterval[1], inter[1]);
            }
            else {
                // non overlapping intervals -> add the new interval to list
                newInterval = inter;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        // 1. Bf
        int[][] intervals = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        List<List<Integer>> result = mergeOverlapInterval(intervals);
        for (List<Integer> interval : result) {
            System.out.print(interval + " ");
        }
        System.out.println();
        
        // 2. Optimal approach :
        int[][] intervals1 = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        List<List<Integer>> result1 = mergeOverlapInterval(intervals1);
        for (List<Integer> interv : result1) {
            System.out.print(interv + " ");
        }
    }
}

/*
Arrays.sort(interval, (a,b) -> a[0] - b[0]);  - Arrays.sort() → Sorts the array. (a, b) -> ... → Lambda expression (Comparator).
a and b represent two sub-arrays being compared.
a[0] - b[0]:
Negative → a comes before b
Positive → b comes before a
Zero → considered equal

*/